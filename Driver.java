//Kiren Kaur
// Honor Pledge: I pledge that I have neither given nor received any help on this assignment

import java.io.*;
import java.lang.*;
import java.util.*;

public class Driver {

public static void main(String[] args) {

  //variables for first and second menu
  //hours variable stores hours worked input
  int answer;
  int secondAnswer = 0;
  int hours = 0;

  //create new scanner
  Scanner newScanner = new Scanner(System.in);

  //menu
  System.out.println("      /--------------------------------/");
  System.out.println("      |         ~ ASSIGNMENT 4 ~       |");
  System.out.println("      |  1. Load students (from file)  |");
  System.out.println("      |  3. Exit Program               |");
  System.out.println("      /--------------------------------/");

  //answer is used to continue to next menu or exit
  System.out.print("Please enter your selection: ");
  answer = newScanner.nextInt();

      //if the user wants to load the file
      if (answer == 1) {
        //new file is created, tells users its been loaded
        File newFile = new File("employees.txt");
        System.out.println("File loaded!");

        //second Menu
        //while the user doesn't enter option 4, keep going
        do {
        System.out.println("      /--------------------------------/");
        System.out.println("      |         ~ ASSIGNMENT 4 ~       |");
        System.out.println("      |  1. Print Employee information |");
        System.out.println("      |  2. Enter Hours Worked         |");
        System.out.println("      |  3. Calculate Paychecks        |");
        System.out.println("      |  4. Exit Program               |");
        System.out.println("      /--------------------------------/");

        //next answer used for this menu
        System.out.print("Please enter your selection: ");
        secondAnswer = newScanner.nextInt();

              //prints employee informaiton
              if (secondAnswer == 1) {
                Employee newEmployee = new Employee();

                //try + catch used to read file
                try {
                  //used to read file
                  BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));

                  //ignore first line
                  reader.readLine();

                  //used to store each line
                  String line = reader.readLine();

                    //while there is content in the file
                    while(line != null) {

                      //creates tokens of the line using comma as delimiter
                      String[] array = line.split(",");

                      //create new instances of each class as well as pass in
                      //hourlyRate as a paramter for each class
                      Employee pharmacyDude = new Pharmacy_Manager(array[1], array[2], array[3], array[4], "50.0");
                      Employee pharmacistDude = new Pharmacist(array[1], array[2], array[3], array[4], "40.0");
                      Employee techDude = new Technician(array[1], array[2], array[3], array[4], "20.0");
                      Employee seniortechDude = new Senior_Technician(array[1], array[2], array[3], array[4], "25.0");

                      //while reading the array, based on job ID, it will access
                      //the according hourlyRate using a getter
                      if (Arrays.asList(array).contains("1")){
                        System.out.println("ID: " + array[1] + "     " + "Start Date: " + array[4] + "       " +
                        "Name: " + array[2] + " "+ array[3] +  "        " + "Rate: " + pharmacyDude.gethourlyRate());

                      } else if (Arrays.asList(array).contains("2")) {
                        System.out.println("ID: " + array[1] + "     " + "Start Date: " + array[4] + "       " +
                        "Name: " + array[2] + " "+ array[3] +  "        " + "Rate: " + pharmacistDude.gethourlyRate());

                      } else if (Arrays.asList(array).contains("3")) {
                        System.out.println("ID: " + array[1] + "     " + "Start Date: " + array[4] + "       " +
                        "Name: " + array[2] + " "+ array[3] +  "        " + "Rate: " + techDude.gethourlyRate());

                      } else {
                        System.out.println("ID: " + array[1] + "     " + "Start Date: " + array[4] + "       " +
                        "Name: " + array[2] + " "+ array[3] +  "        " + "Rate: " + seniortechDude.gethourlyRate());
                      }

                      //read next line
                      line = reader.readLine();

                    }

                //will catch file io errors
                } catch (FileNotFoundException ex) {
                    System.err.println("File not found");
                    System.err.println("java.io.FileNotFoundException: " + newFile);
                    System.out.println(" ");
                    System.out.println("Program exiting... ");
                    break;

                } catch (IOException ex) {
                  System.out.println("IO Exception");
                  System.err.println("java.io.IOException: IO Exception found");
                  System.out.println(" ");
                  System.out.println("Program Exiting...");
                  break;
                }
            }

            //enter hours worked
            else if (secondAnswer == 2) {
                System.out.print("Please enter the hours worked: ");
                hours = newScanner.nextInt();
            }

            //calculates paycheck
            else if (secondAnswer == 3) {
              Employee newEmployee = new Employee();
              try {
                
                BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));

                //ignore first line
                reader.readLine();

                //used to store each line
                String line = reader.readLine();

                  //while there is content in the file
                  while(line != null) {

                    //creates tokens of the line using comma as delimiter
                    //then is stored in a new array each time
                    String[] array = line.split(",");

                    //new instances made, and hourlyRate is passed as a parameter to each class
                    Employee pharmacyDude = new Pharmacy_Manager(array[1], array[2], array[3], array[4], "50.0");
                    Employee pharmacistDude = new Pharmacist(array[1], array[2], array[3], array[4], "40.0");
                    Employee techDude = new Technician(array[1], array[2], array[3], array[4], "20.0");
                    Employee seniortechDude = new Senior_Technician(array[1], array[2], array[3], array[4], "25.0");

                    //will output the ID and the paycheck of the employee
                    if (Arrays.asList(array).contains("1")) {
                      System.out.println("ID: " + array[1] + "     " + "Check Amount: " + (hours * 50.0));

                    } else if (Arrays.asList(array).contains("2")) {
                      System.out.println("ID: " + array[1] + "     " + "Check Amount: " + (hours * 40.0));

                    } else if (Arrays.asList(array).contains("3")) {
                      System.out.println("ID: " + array[1] + "     " + "Check Amount: " + (hours * 20.0));

                    } else {
                      System.out.println("ID: " + array[1] + "     " + "Check Amount: " + (hours * 25.0));
                    }

                    //read next line
                    line = reader.readLine();
                }

                //catch exceptions
                } catch (FileNotFoundException ex) {
                    System.err.println("File not found");
                } catch (IOException ex) {
                  System.out.println("IO Exception");
                }
            //else if the menu answer is not one of those numbers, including quit,
            //it will ask the user to enter a valid option, will loop again
            } else if (secondAnswer != 4 && secondAnswer != 3 && secondAnswer != 2 && secondAnswer !=1) {
              System.out.println("Please enter a valid input!!!");
            }

        }  while (secondAnswer != 4); //program will quit if user presses 4

    }
  }
}
