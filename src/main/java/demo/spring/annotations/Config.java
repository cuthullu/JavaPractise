package demo.spring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private String importantServiceProperty = "hello annotations";

    @Bean(name = "importantServiceProperty")
    public String getImportantServiceProperty() {
        return importantServiceProperty;
    }
}
