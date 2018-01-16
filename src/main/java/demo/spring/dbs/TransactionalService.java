package demo.spring.dbs;

import org.springframework.transaction.annotation.Transactional;

// Use this to remove other XML configurations
//@Transactional
public class TransactionalService {

    public User getUser(int id) {
        throw new UnsupportedOperationException();
    }

    public User getUser(String username) {
        throw new UnsupportedOperationException();
    }

    public void insertUser(User user) {
        throw new UnsupportedOperationException();
    }

    public void updateFoo(User user) {
        throw new UnsupportedOperationException();
    }
}
