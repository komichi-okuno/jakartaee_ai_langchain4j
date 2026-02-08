import java.nio.file.Path;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.pgvector.PgVectorEmbeddingStore;

@ApplicationScoped
public class ManualIngestor {
	@Inject
    private EmbeddingModel embeddingModel;
	
	public void ingestManual(Path pdfPath) {
        // PDFの読み込み
        Document document = FileSystemDocumentLoader.loadDocument(pdfPath, new ApacheTikaDocumentParser());

        // テキストを適切なサイズに分割
        // 今回は500文字ずつにしてみる
        DocumentSplitter splitter = DocumentSplitters.recursive(500, 0);
        
        // PostgreSQL（pgvector）の設定
        EmbeddingStore<TextSegment> embeddingStore = PgVectorEmbeddingStore.builder()
                .host("localhost")
                .port(5432)
                .database("my_vector_db")
                .user("postgres")
                .password("postgres")
                .table("vec")
                .dimension(1536) // OpenAIを使う場合は1536
                .build();

        // まとめて保存
        // Embedding化も自動で行われる
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .documentSplitter(splitter)
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .build();

        ingestor.ingest(document);
    }
}
