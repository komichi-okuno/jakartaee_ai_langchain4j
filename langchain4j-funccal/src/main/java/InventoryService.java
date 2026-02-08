import jakarta.enterprise.context.ApplicationScoped;

import dev.langchain4j.agent.tool.Tool;

@ApplicationScoped
public class InventoryService {
	@Tool("指定された商品の在庫数を確認します。")
    public int getStockLevel(String productName) {
        // 既存のDBアクセスロジック
		// return inventoryRepository.findByName(productName).getQuantity();
		return 66554321;
    }
}
