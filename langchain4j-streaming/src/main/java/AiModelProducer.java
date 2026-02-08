import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;

@ApplicationScoped
public class AiModelProducer {
    @Produces
    @ApplicationScoped
    @Named("streaming-chat-model")
    public StreamingChatModel model() {
        return OpenAiStreamingChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName(System.getenv("OPENAI_MODEL"))
                .build();
    }

}
