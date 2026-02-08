import jakarta.enterprise.context.ApplicationScoped;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.TokenStream;

@RegisterAIService(streamingChatModelName = "streaming-chat-model")
@ApplicationScoped
public interface TechnicalAssistant {
	TokenStream chat(String message);
}
