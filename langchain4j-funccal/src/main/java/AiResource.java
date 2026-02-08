import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/ai")
public class AiResource {
    @Inject
    private InventoryAssistant assistant;
    
    @Inject
    private HttpServletRequest req;

    @GET
    @Path("/chat")
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String askAi(@QueryParam("msg") String msg) {
    	if (msg == null || msg.isBlank()) {
            throw new BadRequestException("msg is required");
        }
    	
    	// セッションをなければ作る
    	String sessionId = req.getSession(true).getId();
    	
        return assistant.chat(sessionId, msg);
    }
}
