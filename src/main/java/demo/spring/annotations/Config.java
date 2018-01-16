package demo.spring.annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("demo.spring.annotations")
public class Config {

    private String importantServiceProperty = "hello annotations";

    @Bean(name = "importantServiceProperty")
    @Qualifier("hi")
    public String getImportantServiceProperty() {
        return importantServiceProperty;
    }
}
