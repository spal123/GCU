package model;

/**
 * date class which stores information about due date
 */
public class ADTDate implements IDate {

  private int theDay;
  private int theMonth;
  private int theYear;
  private int elapsedDays;

  private static int daysInMonth[] = {
    31,
    59,
    90,
    120,
    151,
    181,
    212,
    243,
    273,
    304,
    334,
    365,
  };

  /**
   * constructor of date class
   */
  public ADTDate() {
    this.theDay = 1;
    this.theMonth = 1;
    this.theYear = 1970;
    this.elapsedDays = 0;
  }

  /**
   * parametrized constructor to populate the variables
   * @param dy
   * @param mnth
   * @param yr
   */
  public ADTDate(int dy, int mnth, int yr) {
    this.theDay = dy;
    this.theMonth = mnth;
    this.theYear = yr;
  }

  /**
   * function to set the days
   * @param day
   */
  @Override
  public void setDay(int day) {
    this.theDay = day;
  }

  /**
   * function to get the days
   * @return days
   */
  @Override
  public int getDay() {
    return this.theDay;
  }

  /**
   * function to set the month variable
   * @param month
   */
  @Override
  public void setMonth(int month) {
    this.theMonth = month;
  }

  /**
   * function to get the month
   * @return month
   */
  @Override
  public int getMonth() {
    return this.theMonth;
  }

  /**
   * function to set the year variable of the class
   * @param year
   */
  @Override
  public void setYear(int year) {
    this.theYear = year;
  }

  /**
   * function to get the year
   * @return
   */
  @Override
  public int getYear() {
    return this.theYear;
  }

  /**
   * function to set the days elapsed for each task
   */
  @Override
  public void setElapsedDays() {
    // Check the month. Anything in January is just
    // the current date
    if (this.theMonth == 1) {
      this.elapsedDays = (this.theDay);
    } else {
      this.elapsedDays = (this.theDay) + (daysInMonth[this.theMonth - 2]);
    }

    if (isLeapYear(this.theYear)) {
      this.elapsedDays++;
    }
  }

  /**
   * function to set the elapsed days from the current date
   * @param dd
   * @param mm
   * @param yyyy
   */
  @Override
  public void setElapsedDays(int dd, int mm, int yyyy) {
    int tempDaysElapsed = 0;
    if (mm == 1) {
      tempDaysElapsed = dd;
    } else {
      tempDaysElapsed = dd + (daysInMonth[mm - 2]);
    }
    if (isLeapYear(this.theYear)) {
      tempDaysElapsed++;
    }
    this.elapsedDays = tempDaysElapsed - this.elapsedDays;
  }

  /**
   * function to return the elapsed days for each task
   * @return days elapsed
   */
  @Override
  public int getElapsedDays() {
    return this.elapsedDays;
  }

  /**
   * function to set the date
   * @param dd
   * @param mm
   * @param yyyy
   */
  @Override
  public void setDate(int dd, int mm, int yyyy) {
    this.theDay = dd;
    this.theMonth = mm;
    this.theYear = yyyy;
  }

  /**
   * function to validate the year if it is a leap year or not
   * @param yyyy
   * @return boolean true or false
   */
  @Override
  public boolean isLeapYear(int yyyy) {
    if (yyyy % 100 == 0) {
      if (yyyy % 400 == 0) {
        return true;
      } else {
        return false;
      }
    } else if (yyyy % 4 == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * function to return the string representation of date
   * @return string date
   */
  public String toString() {
    String msg = "";
    msg =
      String.format("%02d/%02d/%02d", this.theDay, this.theMonth, this.theYear);
    return msg;
  }
}
