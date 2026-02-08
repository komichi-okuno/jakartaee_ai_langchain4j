import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

@ApplicationScoped
public class AiModelProducer {
    @Produces
    @ApplicationScoped
    public ChatModel model() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName(System.getenv("OPENAI_MODEL"))
                .build();
    }

}
