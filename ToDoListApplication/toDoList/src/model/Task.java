package model;

/**
 * class task which contains the attributes of the task in the list
 */
public class Task {

  private ListType theList;
  private String theTask;
  private String taskComment;
  private String taskTags;
  private TeamMember teamMember;
  private ADTDate dueDate;

  /**
   * constructor for the task class
   * @param list
   * @param task
   * @param comment
   * @param tags
   * @param tM
   * @param date
   */
  public Task(
    ListType list,
    String task,
    String comment,
    String tags,
    TeamMember tM,
    ADTDate date
  ) {
    theList = list;
    theTask = task;
    taskComment = comment;
    taskTags = tags;
    teamMember = tM;
    dueDate = date;
  }

  /**
   * getter for the type of list for the task
   * @return type of list
   */
  public ListType getTheListType() {
    return theList;
  }

  /**
   * function to set the list type
   * @param theListType
   */
  public void setTheListType(ListType theListType) {
    this.theList = theListType;
  }

  /**
   * function to get the due date for task
   * @returns date object
   */
  public ADTDate getTheDueDate() {
    return dueDate;
  }

  /**
   * function to set the due date for task
   * @param aDueDate
   */
  public void setTheDueDate(ADTDate aDueDate) {
    dueDate = aDueDate;
  }

  /**
   * getter for the task
   * @returns the string for the task
   */
  public String getTheTask() {
    return theTask;
  }

  /**
   * setter for the task
   * @param aTask
   */
  public void setTheTask(String aTask) {
    theTask = aTask;
  }

  /**
   * get the allocated member of the team for the task
   * @return team member object
   */
  public TeamMember getAllocatedTeamMember() {
    return teamMember;
  }

  /**
   * setter for the allocated team member
   * @param allocatedToTM
   */
  public void setAllocatedTeamMember(TeamMember allocatedToTM) {
    teamMember = allocatedToTM;
  }

  /**
   * getter for the comment of task
   * @return task comments string
   */
  public String getTaskComments() {
    return taskComment;
  }

  /**
   * set the comments for the task
   * @param theTaskComments
   */
  public void setTaskComments(String theTaskComments) {
    taskComment = theTaskComments;
  }

  /**
   * getter for the tags of the task
   * @return string of tags for task
   */
  public String getTheTags() {
    return taskTags;
  }

  /**
   * set the tag for the task
   * @param taskTags
   */
  public void setTheTags(String taskTags) {
    this.taskTags = taskTags;
  }

  /**
   * returns the CSV format of the task to write in the file
   * @return string of CSV format
   */
  public String CSVFormat() {
    return (
      getTheListType() +
      "," +
      dueDate.toString() +
      "," +
      theTask +
      "," +
      teamMember.CSVFormat() +
      "," +
      taskComment +
      "," +
      taskTags +
      "\n"
    );
  }

  /**
   * returns the tostring format of the task
   */
  @Override
  public String toString() {
    return (
      "Task{ \nDue Date: " +
      dueDate.toString() +
      "\nTask: " +
      theTask +
      "\nAllocated Team Member: " +
      teamMember.toString() +
      "\nTask Comment: " +
      taskComment +
      "\nTask Tag: " +
      taskTags +
      '}'
    );
  }
}
