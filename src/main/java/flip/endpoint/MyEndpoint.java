package new.endpoint;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("helloworld")
public class MyEndpoint{

    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Hello World",
            description = "Endpoint to hello world.")
    @Counted(unit = MetricUnits.NONE,
            name = "MyEndpointCheckedOut",
            absolute = true,
            monotonic = true,
            displayName = "Checkout MyEndpoint",
            description = "Metrics to show how many times checkoutItems method was called.",
            tags = {"checkout=MyEndpoint"})
    @GET
    public Response findAll(){

        return Response
                .ok("Hello world.")
                .build();
    }




}
