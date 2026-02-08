import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/ai")
public class AiResource {
    @Inject
    private TechnicalAssistant assistant;

    @GET
    @Path("/chat")
    @RolesAllowed("ADMIN")
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String askAi(@QueryParam("msg") String msg) {
        return assistant.chat(msg);
    }
}
