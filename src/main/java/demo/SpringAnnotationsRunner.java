package demo;

import demo.spring.annotations.TodoDao;
import demo.spring.annotations.TodoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationsRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotations.xml");

        TodoServiceImpl service = context.getBean("todoService", TodoServiceImpl.class);
        System.out.println(service.getImportantServiceProperty());

        TodoDao dao = context.getBean("todoDao", TodoDao.class);
        dao.addTodod("Todo: understand databases");

        System.out.println(service.getTodoDao().getTodos().get(0));
    }
}
