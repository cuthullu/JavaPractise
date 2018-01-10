package demo.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TodoServiceImpl todoService() {
        TodoServiceImpl todoService = new TodoServiceImpl("Hello todos annotated");
        todoService.setTodoDao(todoDao());
        return todoService;
    }

    @Bean
    public TodoDao todoDao() {
        return new TodoDao();
    }
}
