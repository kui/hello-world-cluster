package kui.hw;

import io.dropwizard.Application;
import io.dropwizard.discovery.DiscoveryBundle;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Main extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(new DiscoveryBundle<HelloWorldConfiguration>() {
            public DiscoveryFactory getDiscoveryFactory(HelloWorldConfiguration configuration) {
                return configuration.getDiscovery();
            }
        });
    }

    /**
     * 起動準備ができてサーバとして立ち上がる直前のフック
     */
    @Override
    public void run(HelloWorldConfiguration conf, Environment env) throws Exception {
        final HelloWorldResource helloResource = new HelloWorldResource(conf.getMessage());
        env.jersey().register(helloResource);

        final HealthCheck healthCheck = new HealthCheck();
        env.healthChecks().register("default", healthCheck);
    }
}