package view;

import datastructures.ADTSingleLinkedList;
import datastructures.listNode;
import helpers.OutputHelper;
import helpers.TextColours;
import model.ListType;
import model.Task;

/**
 * taskListView this class have methods that prints the Content of each List we
 * have created in Controller class
 */
public class taskListView {

    /**
     * This Function Prints the Attributes of Task object that has been sent to
     * it as a parameter
     *
     * @param aTask of Task Type
     */
    public void displayATask(Task aTask) {
        //        HEADER FOR DOING AND TO-DO LIST
        if (aTask == null) {
            System.out.println("\nList is Empty");
            return;
        }
        if (aTask.getTheListType().equals(ListType.DOING) || aTask.getTheListType().equals(ListType.TODO)) {
            System.out.println(OutputHelper.repeat("-", 137));
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 3, "No.");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 65, "Task");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 40, "Allocated To");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 20, "Due Date");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 30, "Days Elapsed");
            System.out.println("|");
            System.out.println(OutputHelper.repeat("-", 137));

            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 3, "1  ");
            if (aTask.getTheListType().equals(ListType.DOING)) {
                OutputHelper.headerFormat(TextColours.TEXT_YELLOW, 65, aTask.getTheTask());

            } else {
                OutputHelper.headerFormat(TextColours.TEXT_PURPLE, 65, aTask.getTheTask());

            }
            OutputHelper.headerFormat(TextColours.TEXT_BLUE, 40, aTask.getAllocatedTeamMember().toString());
            OutputHelper.headerFormat(TextColours.TEXT_CYAN, 20, aTask.getTheDueDate().toString());

            int elaspedDays = aTask.getTheDueDate().getElapsedDays();
            String daysRemaining;
            if (elaspedDays < 0) {

                daysRemaining = String.valueOf(elaspedDays * -1) + " Days Remaining";
                OutputHelper.headerFormat(TextColours.TEXT_GREEN, 30, daysRemaining);
            } else if (elaspedDays > 0) {
                daysRemaining = String.valueOf(elaspedDays) + " Days Overdue";
                OutputHelper.headerFormat(TextColours.TEXT_RED, 30, daysRemaining);
            } else {
                daysRemaining = "Due Today";
                OutputHelper.headerFormat(TextColours.TEXT_YELLOW, 30, daysRemaining);
            }

            System.out.println("|");

            System.out.println(OutputHelper.repeat("-", 137));
        } //        HEADER FOR DONE LIST
        else {
            System.out.println(OutputHelper.repeat("-", 113));
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 3, "No.");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 65, "Task");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 40, "Allocated To");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 20, "Due Date");

            System.out.println("|");
            System.out.println(OutputHelper.repeat("-", 113));

            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 3, "1  ");
            OutputHelper.headerFormat(TextColours.TEXT_GREEN, 65, aTask.getTheTask());
            OutputHelper.headerFormat(TextColours.TEXT_BLUE, 40, aTask.getAllocatedTeamMember().toString());
            OutputHelper.headerFormat(TextColours.TEXT_CYAN, 20, aTask.getTheDueDate().toString());

            System.out.println("|");

            System.out.println(OutputHelper.repeat("-", 113));
        }

    }

    /**
     * This Function Prints the Entire Content of a List thats head has been
     * passed to it as a parameter
     *
     * @param aTask object of listNode of type Task
     */
    public void displayATask(listNode<Task> aTask) {

        listNode<Task> temp = aTask;

        //        HEADER FOR DOING AND TO-DO LIST
        if (temp == null) {
            System.out.println("\nList is Empty");
            return;
        }

        if (temp.getNodeData().getTheListType().equals(ListType.DOING)
                || temp.getNodeData().getTheListType().equals(ListType.TODO)) {
            System.out.println(OutputHelper.repeat("-", 137));
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 3, "No.");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 65, "Task");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 40, "Allocated To");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 20, "Due Date");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 30, "Days Elapsed");
            System.out.println("|");
            System.out.println(OutputHelper.repeat("-", 137));

            int i = 1;
            while (temp != null) {

                OutputHelper.headerFormat(TextColours.TEXT_WHITE, 3, String.valueOf(i++) + "  ");
                if (temp.getNodeData().getTheListType().equals(ListType.DOING)) {
                    OutputHelper.headerFormat(TextColours.TEXT_YELLOW, 65, temp.getNodeData().getTheTask());

                } else {
                    OutputHelper.headerFormat(TextColours.TEXT_PURPLE, 65, temp.getNodeData().getTheTask());

                }
                OutputHelper.headerFormat(TextColours.TEXT_BLUE, 40,
                        temp.getNodeData().getAllocatedTeamMember().toString());
                OutputHelper.headerFormat(TextColours.TEXT_CYAN, 20, temp.getNodeData().getTheDueDate().toString());

                int elaspedDays = temp.getNodeData().getTheDueDate().getElapsedDays();
                String daysRemaining;
                if (elaspedDays < 0) {

                    daysRemaining = String.valueOf(elaspedDays * -1) + " Days Remaining";
                    OutputHelper.headerFormat(TextColours.TEXT_GREEN, 30, daysRemaining);
                } else if (elaspedDays > 0) {
                    daysRemaining = String.valueOf(elaspedDays) + " Days Overdue";
                    OutputHelper.headerFormat(TextColours.TEXT_RED, 30, daysRemaining);
                } else {
                    daysRemaining = "Due Today";
                    OutputHelper.headerFormat(TextColours.TEXT_YELLOW, 30, daysRemaining);
                }

                System.out.println("|");
                temp = temp.getNextNode();
            }

            System.out.println(OutputHelper.repeat("-", 137));
        } //        HEADER FOR DONE LIST
        else {
            System.out.println(OutputHelper.repeat("-", 113));
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 3, "No.");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 65, "Task");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 40, "Allocated To");
            OutputHelper.headerFormat(TextColours.TEXT_WHITE, 20, "Due Date");

            System.out.println("|");
            System.out.println(OutputHelper.repeat("-", 113));

            int i = 1;
            while (temp != null) {

                OutputHelper.headerFormat(TextColours.TEXT_WHITE, 3, String.valueOf(i++) + "  ");
                OutputHelper.headerFormat(TextColours.TEXT_GREEN, 65, temp.getNodeData().getTheTask());
                OutputHelper.headerFormat(TextColours.TEXT_BLUE, 40,
                        temp.getNodeData().getAllocatedTeamMember().toString());
                OutputHelper.headerFormat(TextColours.TEXT_CYAN, 20, temp.getNodeData().getTheDueDate().toString());

                System.out.println("|");
                temp = temp.getNextNode();
            }

            System.out.println(OutputHelper.repeat("-", 113));
        }

    }

    /**
     * This Function receives a object of ADTSingleLinkedList of Type Task and
     * calls above method and passes List Head to it
     *
     * @param listTasks object of ADTSingleLinkedList of type Task a (List
     * Pointer)
     */
    public void displayListTasks(ADTSingleLinkedList<Task> listTasks) {

        displayATask(listTasks.front());

    }

}
