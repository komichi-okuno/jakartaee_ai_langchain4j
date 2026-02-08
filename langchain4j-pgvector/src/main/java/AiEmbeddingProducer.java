import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModelName;

@ApplicationScoped
public class AiEmbeddingProducer {
	@Produces
    @ApplicationScoped
    public EmbeddingModel embeddingModel() {
        return OpenAiEmbeddingModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY")) // 環境変数から取得
                .modelName(OpenAiEmbeddingModelName.TEXT_EMBEDDING_3_SMALL)
                .build();
    }
}
