import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("../resources/services.xml", "../resources/daos.xml");
    }
}
