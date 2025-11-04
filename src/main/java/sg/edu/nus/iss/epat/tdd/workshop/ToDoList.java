package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;


public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      tasks.put(task.getDescription(), task);
   }

   public void completeTask(String description) {
      tasks.get(description).setComplete(true);
   }

   public boolean getStatus(String description) {
      return getTask(description).isComplete();
   }

   public Task getTask(String description) {
      return tasks.get(description);
   }

   public Task removeTask(String description) {
      Task task = tasks.get(description);
      tasks.remove(description);
      return task;
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      return getAllTasks().stream()
      .filter(Task::isComplete)
      .collect(Collectors.toList());
   }
}
