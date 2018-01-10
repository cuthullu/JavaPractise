package demo.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("todoService")
public class TodoServiceImpl {

    private final String importantServiceProperty;

    private TodoDao todoDao;

    public TodoServiceImpl(String importantServiceProperty) {
        this.importantServiceProperty = importantServiceProperty;
    }

    public TodoDao getTodoDao() {
        return todoDao;
    }

    @Autowired
    public void setTodoDao(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public String getImportantServiceProperty() {
        return importantServiceProperty;
    }
}
