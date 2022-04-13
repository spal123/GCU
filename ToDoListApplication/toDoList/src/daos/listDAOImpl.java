package daos;

import app.ToDoApp;
import datastructures.ADTSingleLinkedList;
import datastructures.listNode;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 * This Class listDAOImpl extends DAO interface and implements
 * all the Abstract method of DAO interface
 */
public class listDAOImpl extends DAO {

  private ADTSingleLinkedList<Task> theTaskLL;

  private Task task;

  public static final char DELIMITER = ',';
  public static final char EOLN = '\n';
  public static final char Slash = '/';
  public static final String QUOTE = "\"";
  public static final String USERDIRECTORY = System.getProperty("user.dir");

  /**
   * Method that gets a String and remove Quotes from starting
   * and ending of that string
   * @param str
   * @return modifeid str
   */
  private String stripQuotes(String str) {
    return str.substring(1, str.length() - 1);
  }

  /**
   * public default Constructor that creats a theTaskLL object of type Task
   */
  public listDAOImpl() {
    theTaskLL = new ADTSingleLinkedList<Task>();
    task = null;
  }

  /**
   * public Parameterized Constructor that creats a theTaskLL object of type Task
   * and set Task Object to task
   * @param ADTSingleLinkedList of type Task
   * @param Task Object
   */
  public listDAOImpl(ADTSingleLinkedList<Task> theTaskLL, Task task) {
    this.task = task;
    this.theTaskLL = theTaskLL;
  }

  /**
   * public function that returns the Object of  ADTSingleLinkedList of
   * type task created
   * @return object of ADTSingleLinkedList of type Task
   */
  public ADTSingleLinkedList<Task> getTheTaskLL() {
    return theTaskLL;
  }

  /**
   * This Method set the Object of ADTSingleLinkedList of type
   * Task to given parameter
   * @param object of ADTSingleLinkedList of type Task
   */
  public void setTheTaskLL(ADTSingleLinkedList<Task> theTaskLL) {
    this.theTaskLL = theTaskLL;
  }

/**
 * This Method receives File Name and loads data from
 * Files to Tasks objects and Add that Tasks objects 
 * to the ADTSingleLinkedList of Type Tasks
 * @param file Name from data should be read
 */
  @Override
  public void loadFromFile(String filename) {
      String transactionFile = USERDIRECTORY + "/" + filename;

      try (
              BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
          // Add your variables here

          String[] temp;
          String line = br.readLine();
          while (line != null && line.length() != 0) {
              Task task = null;

              //                splitting each line read from the file
              temp = getToken(line);
              ADTDate date = new ADTDate(
                      Integer.parseUnsignedInt(temp[1]),
                      Integer.parseUnsignedInt(temp[2]),
                      Integer.parseUnsignedInt(temp[3]));
              date.setElapsedDays();
              //               set task.elapsed days
              DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
              Calendar calobj = Calendar.getInstance();
              String time[] = df.format(calobj.getTime()).split("[/]");
                        

              date.setElapsedDays(
                      Integer.parseInt(time[0]),
                      Integer.parseInt(time[1]),
                      Integer.parseInt(time[2]));
             

              //Team Member Object Creation
              TeamMember tM = null;
              if (temp[7].equalsIgnoreCase("designer")) {
                  tM = new TeamMember(temp[5], temp[6], Role.DESIGNER);
              } else if (temp[7].equalsIgnoreCase("analyst")) {
                  tM = new TeamMember(temp[5], temp[6], Role.ANALYST);
              } else if (temp[7].equalsIgnoreCase("developer")) {
                  tM = new TeamMember(temp[5], temp[6], Role.DEVELOPER);
              }
              if (temp[0].equalsIgnoreCase("todo")) {
                  task = new Task(ListType.TODO, temp[4], temp[8], temp[9], tM, date);
              } else if (temp[0].equalsIgnoreCase("doing")) {
                  task = new Task(ListType.DOING, temp[4], temp[8], temp[9], tM, date);
              } else if (temp[0].equalsIgnoreCase("done")) {
                  task = new Task(ListType.DONE, temp[4], temp[8], temp[9], tM, date);
              }
              //add Task to the List
              theTaskLL.insert(task);
              line = br.readLine();
          }
          br.close();
      } catch (IOException ex) {
          Logger.getLogger(ToDoApp.class.getName()).log(Level.INFO, null, ex);
      }
  }


/**
 * This Method takes ADTSingleLinkedList of type Task
 * and File name and Writes the List Content to the file
 * of which name was provided
 * @param object of ADTSingleLinkedList of type Task
 * @param file Name onto data should be written
 */
 
  @Override
  public void writeToFile(
    ADTSingleLinkedList<Task> listItems,
    String filename
  ) {
      // Add your code here
      FileWriter fw = null;
      try {
          fw = new FileWriter(filename);
      } catch (IOException e1) {
          System.out.println("File Opening Error!");
          System.exit(0);
      }
      listNode<Task> head = listItems.front();
      //Till end of List
      while (head != null) {
          try {
              //Write to the file
              fw.write(head.getNodeData().CSVFormat());
          } catch (IOException e) {
              System.out.println("Error in Writing Data");
              System.exit(0);
          }

          head = head.getNextNode();
      }
      try {
          fw.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

/**
 * This Method insert a Task object in to the List
 * @param object of Class {@link #Task} 
 */
  @Override
  public void add(Task aTask) {
    theTaskLL.insert(aTask);
  }

/**
 * This Method return object of Task type
 * @return object of class Task
 */
  @Override
  public Task getTask() {
      return task;
  }


/**
 * This Method remove Task from List whose
 * index has been passed as parameter and return that Task object
 * @param Index of Object of Task
 * @return object of Task
 */
  @Override
  public Task removeTask(int pos) {
      Task t = null;
      if (theTaskLL.find(theTaskLL.remove(pos).getNodeData())) {
          t = theTaskLL.remove(pos).getNodeData();
          theTaskLL.remove(theTaskLL.remove(pos).getNodeData());
      }
      return t;
  }

/**
 * This Method return object of TeamMember class
 * that have been allocated by the Task
 * @return object of TeamMember Class
 */
  @Override
  public TeamMember getTeamMember() {
      return task.getAllocatedTeamMember();
  }

/**
 * This Function creates object of ADTDate type
 * using the Input string given to it and return that
 * created date Object
 * @param String aDate
 * @return object of ADTDate
 */
  @Override
  public ADTDate parseDateInput(String aDate) {
    String tokens[] = aDate.split("[/]");
    ADTDate date = new ADTDate(
      Integer.parseInt(tokens[0]),
      Integer.parseInt(tokens[1]),
      Integer.parseInt(tokens[2])
    );
    return date;
  }

  /**
   * Function that Splits the Given String into words on DELIMITERS
   * @param input String
   * @return Array of Type String
   */
  public String[] getToken(String str) {
    String pattern =
      "[" +
      String.valueOf(DELIMITER) +
      String.valueOf(Slash) +
      String.valueOf(QUOTE) +
      "]";
    return str.split(pattern);
  }
}
