import jakarta.enterprise.context.ApplicationScoped;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.SystemMessage;

@RegisterAIService
@ApplicationScoped
public interface CodeReviewer {
	@SystemMessage("提出されたコードを分析し、バグの有無と修正案を構造化データで返してください。")
	AnalysisResult chat(String message);
}
