import jakarta.enterprise.context.ApplicationScoped;

import dev.langchain4j.cdi.spi.RegisterAIService;

@RegisterAIService
@ApplicationScoped
public interface TechnicalAssistant {
    String chat(String message);
}
