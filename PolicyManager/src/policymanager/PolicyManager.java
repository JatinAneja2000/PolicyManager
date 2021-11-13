/*
 * Gadget Insurance Policy Prototype
 *                                          Background
 * Gadget Protector requires a simple insurance premium calculator prototype to demonstrate key features.
 * Policy Manager.
 * May 2020.
 */
package policymanager;

import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 * JATIN ANEJA
 * @author w9359412 
 * SCHOOL OF COMPUTING , ENGINEERING AND DIGITAL TECHNOLOGIES
 */
public class PolicyManager {

    /**
     * @param args the command line arguments
     */
    // creat an object *key* to scan an input from keyboard
    // made global 
    static Scanner key = new Scanner(System.in);                
    
    // main class begins
    public static void main(String[] args) throws IOException {
        
        int choice;   // local variable 
        do {
        // MENU of the program     
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");    
        System.out.println("$  1) Enter New Policy :                                  $");
        System.out.println("$  2) Display Summeries of policies :                     $");
        System.out.println("$  3) Display Summmeries of policies of selected month:   $");
        System.out.println("$  4) Find and Diplay Policy :                            $");
        System.out.println("$  5) Exit :                                              $");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        
        
            System.out.print("Enter your Choice : ");
            choice = key.nextInt();
            System.out.println();
            key.nextLine();

            // switch case begins;
            switch (choice) {
                case 1:
                        // option 1 - To Enter new policy in of a customer and append the data in the company database
                    System.out.println("You have Selected to enter a New Policy with our Insurance Company\n");
                    NewPolicy.getNewPolicy();    // calling method from NewPolicy class.
                    break;
                case 2:
                        // option 2 - To Display the summary of the policies in the compay's database 
                        //            A - from Archive Text File  && C - from Current Text File                 
                    Policy_Summary.Display_MyPolicy();
                    break;
                case 3:
                        // option 3 - To Display the summary of all the policies of a particular Month (Jan, Feb etc..)                  
                    PolicySummary_ofSelecetedMonth.Display_MyPolicyof_selectedMonth();
                    break;
                case 4:
                        // option 4 - To find and display the details old polices 
                       //     taking reference id 
                    Find_MyPolicy.get_MyPolicy();
                    break;
                case 5:
                    System.out.println("Thank You for Applying with Our Company. Have a Nice Day;)");
                    exit(0); // exit
                    break;
                default:
                    System.out.println("Please Enter your choice in 1 to 5 only!!");
                    System.out.print("Re- Enter your choice : ");
                    choice = key.nextInt();
                    key.nextLine();
                    break;
            }
        } while (choice != 5);
    }// main ends
}
