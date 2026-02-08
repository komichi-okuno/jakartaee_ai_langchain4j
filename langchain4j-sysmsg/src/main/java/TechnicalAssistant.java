import jakarta.enterprise.context.ApplicationScoped;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

@RegisterAIService
@ApplicationScoped
public interface TechnicalAssistant {
	// @SystemMessage("あなたはJakartaEEのエキスパートです。回答は簡潔に、エンジニア目線で行ってください。")
	@UserMessage("次の質問について、とっても分かりやすく端的に答えてください：{{msg}}")
    String chat(@V("msg") String message);
}
