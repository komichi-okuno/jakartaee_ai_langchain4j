import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.SystemMessage;

@RegisterAIService(
    contentRetrieverName = "manual-retriever"
)
public interface SpecificationAssistant {
	@SystemMessage({
        "あなたは社内のテクニカルサポート担当です。",
        "提供された資料（ナレッジベース）の内容に基づいて、正確に回答してください。",
        "資料にない場合は「分かりません」と答え、勝手に推測しないでください。"
    })
	String answer(String question);
}
