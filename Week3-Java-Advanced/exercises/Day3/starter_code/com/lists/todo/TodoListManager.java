import java.util.ArrayList;
import java.util.List;

public class TodoListManager {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public String getTask(int index) throws IndexOutOfBoundsException {
        if(index > size() || index < 0)
            throw new IndexOutOfBoundsException("Task does not exist!");
        return tasks.get(index);
    }

    public void completeTask(int index) throws IndexOutOfBoundsException{
        if(index > size() || index < 0)
            throw new IndexOutOfBoundsException("Task does not exist!");
        tasks.remove(index);
    }

    public List<String> listTasks() {
        return tasks;
    }

    public int size() {
        return tasks.size();
    }
}