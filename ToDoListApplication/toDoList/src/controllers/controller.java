package controllers;

import daos.listDAOImpl;
import helpers.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.*;
import view.taskListView;

/**
 * Controller Class That Handles Data Logic and
 * Interact with Data Model
 */

public class controller {

  //Add your variables here
  InputHelper inputHelper;
  listDAOImpl todo;
  listDAOImpl doing;
  listDAOImpl done;
  taskListView out;

  /**
   * Public Constructor For Controller Class that Creates
   * three Objects of listDAOImpl class for our
   * three Type of Lists i.e. (To Do, Doing, Done)
   */
  public controller() {
    // Add your code here.
    inputHelper = new InputHelper();
    //Initializing Objects
    todo = new listDAOImpl();
    doing = new listDAOImpl();
    done = new listDAOImpl();
    out = new taskListView();
  }

  /**
   * Run method that Calls Some Methods
   * according to user choice and Some other Methods
   * to Populate Data into Lists
   */
  public void run() {
    this.setup();
    boolean finished = false;
    int iChoice = 0;

    do {
      this.theMenu();
      iChoice = inputHelper.readInt("Enter choice", 8, 1);
      switch (iChoice) {
        // Add more cases
        case 8:
          {
            //Exit
            exit();
            break;
          }
        case 1:
          {
            //Display Todo List
            displayToDolist();
            break;
          }
        case 2:
          {
            //Display Doing List
            displayDoingList();
            break;
          }
        case 3:
          {
            //Display Done List
            displayDoneList();
            break;
          }
        case 4:
          {
            //Display All Lists
            displayAllLists();
            break;
          }
        case 5:
          {
            //Add New Task
            addNewTask();
            break;
          }
        case 6:
          {
            //Move Task from toDo List to Doing List
            moveTODOtoDoing();

            break;
          }
        case 7:
          {
            //Move Task from Doing List to Done List
            moveDoingToDone();
            break;
          }
        default: // invalid option
          System.out.println("Oops! Something has went wrong!");
          break;
      }
    } while (!finished);
  }

  /**
   * This Method Populates listDAOImpl objects with Data
   * by calling their loadFromFile methods and sends file names
   */
  private void setup() {
    try {
      //Load Data from Files and Populate the Lists
      todo.loadFromFile("toDoList.txt");
      doing.loadFromFile("doingList.txt");
      todo.loadFromFile("doneList.txt");
      System.out.println("Data Loaded Successfully!");
    } catch (Exception e) {
      System.out.println("Error in Loading..!");
    }
  }

  /**
   * theMenu Methods Prompts the user available action that user can perform
   */
  private void theMenu() {
    // Print menu to console
    System.out.println("");
    System.out.println("1: View the Todo List");
    System.out.println("2: View the Doing List");
    System.out.println("3: View the Done List");
    System.out.println("4: View All the Lists");
    System.out.println("5: Add a new Task to the Todo List");
    System.out.println("6: Move Task from the Todo to Doing List");
    System.out.println("7: Move Task from the Doing to Done List");
    System.out.println("8: Exit");
    System.out.println("");
  }

  // Add your code here
  // Add more private methods for each of your cases

  /**
   * exit Method invoked when User wants to Exit the Application
   * It Also Call
   * to rewrite the Populated and modified data onto files
   */
  private void exit() {
    System.out.println("Exiting the To Do App.");
    //data write to file
    todo.writeToFile(todo.getTheTaskLL(), "toDoList.txt");
    todo.writeToFile(doing.getTheTaskLL(), "doingList.txt");
    todo.writeToFile(done.getTheTaskLL(), "doneList.txt");
    System.exit(0);
  }

  //Case 1
  /**
   * This Method Calls View Method to display Todo List
   */
  private void displayToDolist() {
    if (todo.getTheTaskLL().isEmpty()) {
      System.out.println("The To Do List is Empty");
    } else {
      System.out.println(" Viewing To Do List");
      System.out.println(OutputHelper.repeat("-", 18));
      out.displayListTasks(todo.getTheTaskLL());
    }
  }

  //Case 2
  /**
   * This Method Calls View Method to display doing List
   */
  private void displayDoingList() {
    if (doing.getTheTaskLL().isEmpty()) {
      System.out.println("The Doing List is Empty");
    } else {
      System.out.println(" Viewing Doing List");
      System.out.println(OutputHelper.repeat("-", 18));

      out.displayListTasks(doing.getTheTaskLL());
    }
  }

  //Case 3
  /**
   * This Method Calls View Method to display Done List
   */
  private void displayDoneList() {
    if (done.getTheTaskLL().isEmpty()) {
      System.out.println("The Done List is Empty");
    } else {
      System.out.println(" Viewing Done List");
      System.out.println(OutputHelper.repeat("-", 17));
      out.displayListTasks(done.getTheTaskLL());
    }
  }

  //Case 4
  /**
   * This Method Calls View Method to display All Lists
   */
  private void displayAllLists() {
    if (todo.getTheTaskLL().isEmpty()) {
      System.out.println("The Todo List is Empty");
    } else {
      System.out.println("\n Viewing To Do List");
      System.out.println(OutputHelper.repeat("-", 18));
      out.displayListTasks(todo.getTheTaskLL());
    }
    if (doing.getTheTaskLL().isEmpty()) {
      System.out.println("The Doing List is Empty");
    } else {
      System.out.println("\n Viewing Doing List");
      System.out.println(OutputHelper.repeat("-", 18));
      out.displayListTasks(doing.getTheTaskLL());
    }
    if (done.getTheTaskLL().isEmpty()) {
      System.out.println("The Done List is Empty");
    } else {
      System.out.println("\n Viewing Done List");
      System.out.println(OutputHelper.repeat("-", 17));
      out.displayListTasks(done.getTheTaskLL());
    }
  }

  //Case 5
  /**
   * This Method Takes Inputs From user Creates a Task Object and send it to
   * listDAOImpl object's insert Method so it can be added to the List
   */
  private void addNewTask() {
    String task, taskComment, tag, firstName, lastName, role;
    task = inputHelper.readString("Enter Task to DO: ");
    Calendar calendar = inputHelper.readDate(
      "Enter Due Date: (format: dd/MM/yyyy) ",
      "dd/MM/yy"
    );
    firstName =
      inputHelper.readString("Enter First Name of the Allocated Team Member: ");
    lastName =
      inputHelper.readString("Enter Last Name of the Allocated Team Member: ");
    role =
      inputHelper.readString(
        "Enter Role of the Allocated Team Member (Designer,Analyst,Developer): "
      );
    taskComment = inputHelper.readString("Enter Task Comment: ");
    tag = inputHelper.readString("Enter Task Tags: ");
    Role theRole = null;

    if (role.equalsIgnoreCase("Designer")) {
      theRole = Role.DESIGNER;
    } else if (role.equalsIgnoreCase("Analyst")) {
      theRole = Role.ANALYST;
    } else if (role.equalsIgnoreCase("Developer")) {
      theRole = Role.DEVELOPER;
    } else {
      theRole = Role.ANALYST;
    }
    TeamMember tm = new TeamMember(firstName, lastName, theRole);

    ADTDate date = new ADTDate(
      calendar.get(Calendar.DAY_OF_MONTH),
      calendar.get(Calendar.MONTH) + 1,
      calendar.get(calendar.YEAR)
    );
    date.setElapsedDays();
    DateFormat df = new SimpleDateFormat("dd/MM/yy");
    Calendar calobj = Calendar.getInstance();
      
    String time= df.format(calobj.getTime());
    String time1[]=time.split("[/]");
    
    date.setElapsedDays(
      Integer.parseInt(time1[0]),
      Integer.parseInt(time1[1]),
      Integer.parseInt(time1[2])
    );
    Task newTask = new Task(ListType.TODO, task, taskComment, tag, tm, date);
    todo.getTheTaskLL().insert(newTask);
      System.out.println("\nAdding New Task...");
    out.displayATask(newTask);
    out.displayATask(todo.getTheTaskLL().front());
  }

  //Case 6
  /**
   * This Method calls removeTask and insert methods of
   * listDAOImpl to move a task from ToDo List to Doing List
   */
  private void moveTODOtoDoing() {
    int index = inputHelper.readInt(
      "Please Enter the index value of item You wish to Move"
    );
    if (index <= 0 && index > todo.getTheTaskLL().length()) {
      System.out.println("Index Item Does Not Exist!\nTry Again..!");
    } else {
      Task getTask = todo.removeTask(index);
      if (getTask != null) {
        out.displayATask(getTask);
        System.out.println("\nMoving to the Doing List ...");
        getTask.setTheListType(ListType.DOING);
        doing.getTheTaskLL().insert(getTask);
        out.displayListTasks(doing.getTheTaskLL());
      } else {
        System.out.println("Task not Found!");
      }
    }
  }

  //Case 7
  /**
   * This Method calls removeTask and insert methods of
   * listDAOImpl to move a task from Doing List to Done List
   */
  private void moveDoingToDone() {
    int index = inputHelper.readInt(
      "Please Enter the index value of item You wish to Move"
    );
    if (index <= 0 && index > doing.getTheTaskLL().length()) {
      System.out.println("Index Item Does Not Exist!\nTry Again..!");
    } else {
      Task getTask = doing.removeTask(index);
      if (getTask != null) {
        out.displayATask(getTask);
        System.out.println("\nMoving to the Doing List ...");
        getTask.setTheListType(ListType.DONE);
        done.getTheTaskLL().insert(getTask);
        out.displayListTasks(done.getTheTaskLL());
      } else {
        System.out.println("Task not Found!");
      }
    }
  }
}
