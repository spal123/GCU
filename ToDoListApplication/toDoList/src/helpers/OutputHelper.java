package helpers;

public class OutputHelper {

  /**
   * function which returns the n times string of the given character
   * @param character
   * @param times
   * @return String of characters
   */
  public static final String repeat(String character, int times) {
    String theText = " ";
    for (int num = 0; num < times; num++) {
      theText += character;
    }
    return theText;
  }

  /**
   * function which prints the header of the output
   * @param color
   * @param sp
   * @param data
   * @return
   */
  public static final String headerFormat(String color, int sp, String data) {
    data = color + data + TextColours.TEXT_RESET;
    System.out.print(" | ");
    String format = "%-" + sp + "s";
    System.out.printf(format, data);

    return "";
  }
}
