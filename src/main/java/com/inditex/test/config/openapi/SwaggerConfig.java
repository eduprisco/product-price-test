package com.inditex.test.config.openapi;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Initializes all the parameter necessary for swagger api
 */
@Configuration
public class SwaggerConfig {

    @Value("${api.info.title}")
    String title;

    @Value("${api.info.description}")
    String description;

    @Value("${api.info.version}")
    String version;

    @Value("${api.info.apiVersion}")
    String apiVersion;

    @Value("${api.server.serviceUrl}")
    String url;

    @Value("${api.server.pathMapping}")
    String pathMapping;

    @Value("${api.info.description}")
    String apiDescription;

    @Value("${api.service.applicationName}")
    String applicationName;

    /**
     * Create Swagger OpenAPI Configuration.
     *
     * @return OpenAPI model
     */

    @Bean
    OpenAPI apiVehicleCalculator() {

        ServerVariables serverVariables = new ServerVariables();
        ServerVariable serverVariable =new ServerVariable();
        serverVariable._default(pathMapping + apiVersion);

        serverVariable.description( "Base path for accessing to the service operations");

        serverVariables.addServerVariable("basePath", serverVariable);

        Server server = new Server();
        server.url(url + pathMapping + apiVersion);
        server.description(applicationName + " service");
        server.variables(serverVariables);

        return new OpenAPI()
                .addServersItem(server)
                .info(new Info().title(title)
                        .description(description)
                        .version(version)
                        .license(new License().name("Apache 2.0").url("https://swagger.io/license")))
                .externalDocs(new ExternalDocumentation());
    }
}
