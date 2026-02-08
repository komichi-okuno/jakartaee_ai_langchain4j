import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

@ApplicationScoped
@Named("per-user-memory") // メモリに名前をつける
public class UserChatMemoryProvider implements ChatMemoryProvider {
	private final Map<String, ChatMemory> memories = new ConcurrentHashMap<>();

    @Override
    public ChatMemory get(Object memoryId) {
        String id = String.valueOf(memoryId);
        return memories.computeIfAbsent(id,
            key -> MessageWindowChatMemory.withMaxMessages(20));
    }
}
