package config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        // Aquí debes especificar el paquete donde se encuentran tus clases de recursos
        packages("resource");
    }
}
