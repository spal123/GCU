
import controllers.controller;
import daos.listDAOImpl;
import helpers.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.*;
import view.taskListView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author waniya_mustafa
 */
public class Tests {

//    test case 1 Date Validation
    public static void dateValidation() {
        InputHelper obj = new InputHelper();
        //Expected Output Exception
        obj.readDate("Enter Date", "dd/mm/yyyy");

    }

//    test case 2 data population method
    public static void dataPopulation() {
        TeamMember tm = new TeamMember("John", "James", Role.ANALYST);

        ADTDate date = new ADTDate(
                03,
                12,
                2022
        );
        Task newTask = new Task(ListType.TODO, "Submit DSA Assignment", "Assignment 2 about linked lists", "DSA:Java", tm, date);
        System.out.println(newTask.CSVFormat());

    }
//    test case 3 Insertion method

    public static void insertion() {
        listDAOImpl todo = new listDAOImpl();
        listDAOImpl doing = new listDAOImpl();
        listDAOImpl done = new listDAOImpl();
        TeamMember tm = new TeamMember("John", "JamÏes", Role.ANALYST);

        ADTDate date = new ADTDate(
                03,
                12,
                2022
        );
        Task newTask = new Task(ListType.TODO, "Submit DSA Assignment", "Assignment 2 about linked lists", "DSA:Java", tm, date);
        taskListView view = new taskListView();
        todo.getTheTaskLL().insert(newTask);
        System.out.println("\nPrinting all the lists:\nTo Do List:\n");
        view.displayListTasks(todo.getTheTaskLL());
        System.out.println("\nDoing List\n");
        view.displayListTasks(doing.getTheTaskLL());
        System.out.println("\nDone List\n");
        view.displayListTasks(done.getTheTaskLL());

    }
//    test case 4 Moving a task from to do to doing list

    public static void moveTaskToDoing() {
        listDAOImpl todo = new listDAOImpl();
        listDAOImpl doing = new listDAOImpl();
        listDAOImpl done = new listDAOImpl();
        TeamMember tm = new TeamMember("John", "James", Role.ANALYST);

        ADTDate date = new ADTDate(
                03,
                12,
                2022
        );
        Task newTask = new Task(ListType.TODO, "Submit DSA Assignment", "Assignment 2 about linked lists", "DSA:Java", tm, date);
        taskListView view = new taskListView();
        todo.getTheTaskLL().insert(newTask);
        Task temp = todo.removeTask(1);
        view.displayATask(temp);
        doing.getTheTaskLL().insert(temp);
        System.out.println("\nPrinting all the lists:\nTo Do List:\n");
        view.displayListTasks(todo.getTheTaskLL());
        System.out.println("\nDoing List\n");
        view.displayListTasks(doing.getTheTaskLL());
        System.out.println("\nDone List\n");
        view.displayListTasks(done.getTheTaskLL());

    }

//    test case 4 Moving a task from to do to doing list
    public static void moveTaskToDone() {
        listDAOImpl todo = new listDAOImpl();
        listDAOImpl doing = new listDAOImpl();
        listDAOImpl done = new listDAOImpl();
        TeamMember tm = new TeamMember("John", "James", Role.ANALYST);

        ADTDate date = new ADTDate(
                03,
                12,
                2022
        );
        Task newTask = new Task(ListType.TODO, "Submit DSA Assignment", "Assignment 2 about linked lists", "DSA:Java", tm, date);
        taskListView view = new taskListView();
        todo.getTheTaskLL().insert(newTask);
        Task temp = todo.removeTask(1);

        doing.getTheTaskLL().insert(temp);
        Task temp2 = doing.removeTask(1);
        view.displayATask(temp2);
        done.getTheTaskLL().insert(temp2);
        System.out.println("\nPrinting all the lists:\nTo Do List:\n");
        view.displayListTasks(todo.getTheTaskLL());
        System.out.println("\nDoing List\n");
        view.displayListTasks(doing.getTheTaskLL());
        System.out.println("\nDone List\n");
        view.displayListTasks(done.getTheTaskLL());

    }

    public static void main(String[] args) {
        dateValidation();
        dataPopulation();
insertion();
 moveTaskToDoing();
        moveTaskToDone();
    }

}
