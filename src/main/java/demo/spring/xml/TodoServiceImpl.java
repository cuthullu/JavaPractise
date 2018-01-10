package demo.spring.xml;

public class TodoServiceImpl {

    private final String importantServiceProperty;

    private TodoDao todoDao;

    public TodoServiceImpl(String importantServiceProperty) {
        this.importantServiceProperty = importantServiceProperty;
    }

    public TodoDao getTodoDao() {
        return todoDao;
    }

    public void setTodoDao(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public String getImportantServiceProperty() {
        return importantServiceProperty;
    }
}
