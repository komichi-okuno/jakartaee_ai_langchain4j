import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.pgvector.PgVectorEmbeddingStore;

@ApplicationScoped
public class AiComponents {
	@Produces
    @Named("manual-retriever")
    public ContentRetriever contentRetriever(EmbeddingModel model) {
        EmbeddingStore<TextSegment> store = PgVectorEmbeddingStore.builder()
        		.host("localhost")
                .port(5432)
                .database("my_vector_db")
                .user("postgres")
                .password("postgres")
                .table("vec")
                .dimension(1536)
                .build();

        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(store)
                .embeddingModel(model)
                .maxResults(3) // 関連する上位3件を参照
                .build();
    }
}
