package sg.iss.day24.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    @Bean
    public openAPI openAPI() {
        return new openAPI().info(new Info()
            .title("PAF Day24 lecture")
            .description("Bank account transaction example")
            .version("version 1.0"));
    }
}
