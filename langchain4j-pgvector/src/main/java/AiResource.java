import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ai")
public class AiResource {
    @Inject
    private SpecificationAssistant assistant;
    
    @Inject
    private ManualIngestor ingestor;

    @GET
    @Path("/chat")
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String askAi(@QueryParam("msg") String msg) {
    	if (msg == null || msg.isBlank()) {
            throw new BadRequestException("msg is required");
        }
    	
        return assistant.answer(msg);
    }
    
    @POST
    @Path("/ingest")
    public Response triggerIngest(@QueryParam("fileName") String fileName) {
        // 特定のディレクトリにある指定ファイルを読み込む
    	java.nio.file.Path path = Paths.get(System.getenv("PDF_DIRECTORY_PATH") + fileName);
    	System.err.print("■: " + path);
        
        if (!Files.exists(path)) {
            return Response.status(404).entity("ファイルが見つかりません").build();
        }

        ingestor.ingestManual(path);
        return Response.ok("インデックス化が成功しました: " + fileName).build();
    }
}
