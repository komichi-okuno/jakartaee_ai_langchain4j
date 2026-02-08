import dev.langchain4j.model.openai.OpenAiChatModel;

public class HelloAI {
	public static void main(String[] args) {
		// builder() を使用して構築
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName("gpt-4o") // モデル名の指定が推奨されます
                .build();

        // chat() メソッドを使用（Stringを引数に取るとStringが返るシンプルな形式）
        String answer = model.chat("Jakarta EEとAIを組み合わせるメリットを1行で教えて。");

        // 結果の表示
        System.out.println("AIの回答: " + answer);
    }
}
