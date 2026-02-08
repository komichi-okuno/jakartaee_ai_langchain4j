import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/ai")
public class AiResource {
    @Inject
    private CodeReviewer reviewer;

    @GET
    @Path("/chat")
    @Produces(MediaType.APPLICATION_JSON)
    public AnalysisResult askAi(@QueryParam("msg") String msg) {
        return reviewer.chat(msg);
    }
}
