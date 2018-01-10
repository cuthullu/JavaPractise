package demo.spring.annotations;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Repository
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
