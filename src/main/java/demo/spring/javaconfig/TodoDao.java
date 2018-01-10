package demo.spring.javaconfig;

import java.util.ArrayList;

public class TodoDao {

    private ArrayList<String> todos;

    public TodoDao() {
        todos = new ArrayList<>();
    }

    public ArrayList<String> getTodos() {
        return todos;
    }

    public void setTodos(ArrayList<String> todos) {
        this.todos = todos;
    }

    public void addTodod(String todo) {
        todos.add(todo);
    }
}
