package kui.hw;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/")
public class HelloWorldResource {

    private final String message;
    private final AtomicLong counter;

    public HelloWorldResource(String message) {
        this.message = message;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public String doGreet() {
        final long c = counter.incrementAndGet();
        return String.format("\"%s (%d)\"", message, c);
    }
}
