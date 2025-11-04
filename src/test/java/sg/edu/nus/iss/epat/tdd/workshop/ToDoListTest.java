package sg.edu.nus.iss.epat.tdd.workshop;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.fail;

public class ToDoListTest  {
    // Define Test Fixtures
    ToDoList toDoList;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        toDoList = new ToDoList();
    }

    @After
    public void tearDown() throws Exception {
        toDoList = null;
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task("Add Test");
        toDoList.addTask(newTask);

        assertEquals(newTask, toDoList.getTask("Add Test"));

        Task newTask1 = new Task("Add Test 2");
        toDoList.addTask(newTask1);
        
        assertEquals(newTask1, toDoList.getTask("Add Test 2"));
    }

    @Test
    public void testGetStatus() {
        Task newTask = new Task("Get Status Test");
        toDoList.addTask(newTask);

        assertEquals(false, toDoList.getStatus("Get Status Test"));

        toDoList.completeTask("Get Status Test");

        assertEquals(true, toDoList.getStatus("Get Status Test"));


    }

    @Test
    public void testRemoveTask() {
        Task newTask = new Task("Remove Task Test");
        toDoList.addTask(newTask);

        assertEquals(newTask, toDoList.removeTask("Remove Task Test"));
        
        assertEquals(null, toDoList.getTask("Remove Task Test"));
    }

    @Test
    public void testGetCompletedTasks() {
        Task task1 = new Task("Get Completed Test 1");
        toDoList.addTask(task1);

        Task task2 = new Task("Get Completed Test 2");
        toDoList.addTask(task2);

        Task task3 = new Task("Get Completed Test 3");
        toDoList.addTask(task3);

        toDoList.getTask("Get Completed Test 1").setComplete(true);
        toDoList.getTask("Get Completed Test 3").setComplete(true);

        ArrayList<Task> res = new ArrayList<>();

        task1.setComplete(true);
        task3.setComplete(true);

        res.add(task1);
        res.add(task3);

        Collection<Task> completedTasks = toDoList.getCompletedTasks();
        ArrayList<Task> completedList = new ArrayList<>(completedTasks);

        assertEquals(true, completedList.containsAll(res));
        assertEquals(res.size(), completedList.size());
    }
}