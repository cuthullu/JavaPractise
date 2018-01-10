import demo.spring.xml.TodoDao;
import demo.spring.xml.TodoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

        TodoServiceImpl service = context.getBean("todoService", TodoServiceImpl.class);
        System.out.println(service.getImportantServiceProperty());

        TodoDao dao = context.getBean("todoDao", TodoDao.class);
        dao.addTodod("Todo: understand databases");

        System.out.println(service.getTodoDao().getTodos().get(0));
    }
}
