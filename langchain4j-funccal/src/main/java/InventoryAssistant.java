import jakarta.enterprise.context.SessionScoped;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

@RegisterAIService(
    chatMemoryProviderName = "per-user-memory",
    // 在庫チェックツールを持つ CDI Bean を登録
    tools = { InventoryService.class }
)
@SessionScoped
public interface InventoryAssistant {
	String chat(@MemoryId String userId, @UserMessage String message);
}
