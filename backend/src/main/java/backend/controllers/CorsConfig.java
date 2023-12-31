package backend.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig {
    
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/goals/prompt").allowedOrigins("http://localhost:4200").allowedMethods("GET", "PUT", "DELETE","POST").allowCredentials(true);
        registry.addMapping("/goals/all").allowedOrigins("http://localhost:4200").allowedMethods("GET","PUT","DELETE","POST").allowCredentials(true);
        registry.addMapping("/goals/complete").allowedOrigins("http://localhost:4200").allowedMethods("GET","PUT","DELETE","POST").allowCredentials(true);
    }
}
