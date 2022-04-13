package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author mga
 */
public class InputHelper {
    private final Scanner reader;
    
    /**
     * constructor
     */
    public InputHelper() {
        reader = new Scanner(System.in);
    }

    // Read Character

    /**
     *
     * @param prompt
     * @return
     */
        public char readCharacter(String prompt) {
        System.out.println(prompt + ": ");
        char inputText = reader.nextLine().charAt(0);
        return inputText;
    }    
    
    // Read Character - set of valid values

    /**
     *
     * @param prompt
     * @param validCharacters
     * @return
     */
        public char readCharacter(String prompt, String validCharacters) {
        char inputText;
        boolean inputError;        
        do {
            inputError = false;             
            System.out.println(prompt + ": ");
            inputText = reader.nextLine().toUpperCase().charAt(0);
            if (validCharacters.indexOf(inputText) == -1) {
                inputError = true;
                System.out.println("Character out of range: please re-enter: "); 
            }
        } while (inputError);        
        return inputText;
    }     
    
    // Read String

    /**
     *
     * @param prompt
     * @return
     */
        public String readString(String prompt) {
        
        System.out.println(prompt + ": ");
        String inputText = reader.nextLine();
        return inputText;
    }
    
    // Read Int

    /**
     *
     * @param prompt
     * @param max
     * @param min
     * @return
     */
        public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;                
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");                        
                }
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    } 
    
    // Read Int

    /**
     *
     * @param prompt
     * @return
     */
        public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;                
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }     
    
    // Read Float

    /**
     *
     * @param prompt
     * @return
     */
        public double readDouble(String prompt) {
        double inputNumber = 0.0;
        boolean inputError;
        do {
            inputError = false;                
            System.out.println(prompt + ": ");

            try {
                inputNumber = Double.parseDouble(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }     
    
    // Read Date

    /**
     *
     * @param prompt
     * @param format
     * @return
     */
        public Calendar readDate(String prompt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateInString = readString(prompt);
        Date date = null;
         Calendar calendar = Calendar.getInstance();
         try {
            //Validation for Entered Day,Month,
            sdf.setLenient(false);
            date = sdf.parse(dateInString);
           calendar.setTime(date);  
        } catch (ParseException ex) {
            System.err.println("Date Format OR Date ranges are Wrong!");
            System.exit(0);
        }
        
        return calendar;
    }
}
