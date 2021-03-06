package demo;

import demo.spring.javaconfig.AppConfig;
import demo.spring.javaconfig.TodoDao;
import demo.spring.javaconfig.TodoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TodoServiceImpl service = context.getBean("todoService", TodoServiceImpl.class);
        System.out.println(service.getImportantServiceProperty());

        TodoDao dao = context.getBean("todoDao", TodoDao.class);
        dao.addTodod("Todo: understand databases");

        System.out.println(service.getTodoDao().getTodos().get(0));
    }
}
