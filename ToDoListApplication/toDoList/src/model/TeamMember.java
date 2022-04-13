package model;


/**
 * Team Member Class That Gives the view of 
 * Allocated Team Member to whom Task has been Assigned
*/
public class TeamMember {

    private String firstName;
    private String lastName;
    private Role tmRole;

/**
 * Default Constructor that Initializes attributes of 
 * Team Member
 */
public TeamMember() {
    firstName = "";
    lastName = "";
    this.tmRole = Role.ANALYST;
}

/**
 * Parameterized Constructor  
 * @param theFirstname first Name of Team Member
 * @param theLastname Last Name of Team Member
 * @param theRole Role of Team Member
 */
public TeamMember(String theFirstname, String theLastname, Role theRole) {
    firstName = theFirstname;
    lastName = theLastname;
    this.tmRole = theRole;
}


/**
 * this Function returns First Name of Team Member
 * @return first Name of Team Member
 */
public String getFirstname() {
    return firstName;
}

/**
 * Sets the First Name of The Team Member
 * @param firstname first Name of The Team Member
 */
    public void setFirstname(String firstname) {
        firstName = firstname;
    }

/**
 * this Function returns Last Name of Team Member
 * @return Last Name of Team Member
 */
public String getLastname() {
    return lastName;
}

/**
 * Sets the Last Name
 * @param lastname Last Name of Team Member
 */
    public void setLastname(String lastname) {
        lastName = lastname;
    }

/**
 * this Function returns Role of Team Member
 * @return Role of Team Member
 */
public Role getTmRole() {
    return tmRole;
}

/**
 * Sets the Role
 * @param tmRole Role of the Team Member
 */
    public void setTmRole(Role tmRole) {
        this.tmRole = tmRole;
    }
/**
 * this Function returns Role as String of Team Member
 * @return Role as a String of Team Member
 */
    public String getRoleAsString() {
        return tmRole.toString();
    }
/**
 * this Function returns First Name  and Last Name of Team Member
 * @return first Name and Last Name of Team Member
 */
public String getAllocatedTo() {
    return firstName + lastName;
}


/**
 * this Function returns CSV Format of Data Team Member
 * @return CSV Format of Data  of Team Member
 */
public String CSVFormat() {

    return firstName + "," + lastName + "," + tmRole;
}
/**
 * this Function returns Human Readable Format of  Team Member
 * @return Human Readable Format of Team Member
 */
    @Override
    public String toString() {

        return firstName + " " + lastName + "," + tmRole;
    }
}
