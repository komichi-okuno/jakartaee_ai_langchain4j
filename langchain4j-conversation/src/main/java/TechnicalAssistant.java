import jakarta.enterprise.context.ApplicationScoped;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

@RegisterAIService(
	chatMemoryProviderName = "per-user-memory"
)
@ApplicationScoped
public interface TechnicalAssistant {
    String chat(@MemoryId String sessionId, @UserMessage String message);
}
