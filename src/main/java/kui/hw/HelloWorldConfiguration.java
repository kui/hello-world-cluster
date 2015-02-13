package kui.hw;

import io.dropwizard.Configuration;
import io.dropwizard.discovery.DiscoveryFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    @NotNull
    private String message = "Hello World.";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Valid
    @NotNull
    private DiscoveryFactory discovery = new DiscoveryFactory();

    @JsonProperty("discovery")
    public DiscoveryFactory getDiscovery() {
        return discovery;
    }

    @JsonProperty("discovery")
    public void setDiscovery(DiscoveryFactory discoveryFactory) {
        this.discovery = discoveryFactory;
    }
}
