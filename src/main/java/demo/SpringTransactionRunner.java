package demo;

import demo.spring.dbs.TransactionalService;
import demo.spring.dbs.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dataAccess.xml");
        TransactionalService transactionalService = (TransactionalService) context.getBean("transactionalService");

        User user = transactionalService.getUser(43);
        System.out.println(user.getEmail());
    }
}
