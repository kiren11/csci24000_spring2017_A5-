//Kiren Kaur
// Honor Pledge: I pledge that I have neither given nor received any help on this assignment

//public class Employee
public class Employee {

    private String employeeID;
    private String firstName;
    private String lastName;
    private String startDate;
    public String hourlyRate;

    //constructor
    public Employee() {}

    //private getters and setters for each variable
    public void setemployeeID(String employeeID) {
      this.employeeID = employeeID;
    }

    public String getemployeeID() {
      return employeeID;
    }

    public void setfirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getfirstName() {
      return firstName;
    }

    public void setlastName(String lastName) {
      this.lastName = lastName;
    }

    public String getlastName() {
      return lastName;
    }

    public void setstartDate(String startDate) {
      this.startDate = startDate;
    }

    public String getstartDate() {
      return startDate;
    }

    public void sethourlyRate(String hourlyRate) {
      this.hourlyRate = hourlyRate;
    }

    public String gethourlyRate() {
      return hourlyRate;
    }
}
