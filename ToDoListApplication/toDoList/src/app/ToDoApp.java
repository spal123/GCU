package app;

import controllers.controller;

/** 
 * Class ToDoApp that Invokes Controller Run Method to Start Application
*/
public class ToDoApp {
    /**
     * Creates a Controller object and
     * sends it a run message
     */
    private static void run() {
        final controller controller = new controller();
        controller.run();
    }

    /**
     * Starts the application by invoking the class method run
     */
    public static void main(final String[] args) { 
        ToDoApp.run();
    }
}
