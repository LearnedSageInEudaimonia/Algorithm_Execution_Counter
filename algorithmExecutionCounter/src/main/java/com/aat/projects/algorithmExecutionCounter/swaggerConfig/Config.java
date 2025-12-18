package com.aat.projects.algorithmExecutionCounter.swaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Algorithm Execution Counter API")
                        .version("1.0")
                        .description("API to execute and count comparisons & swaps of sorting algorithms"));
    }
}
