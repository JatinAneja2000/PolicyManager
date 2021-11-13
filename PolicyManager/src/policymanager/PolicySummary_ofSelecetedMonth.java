/**
 * Class - Option3 -> Peeking into the Records(Archives & Current) and Summarizing the data for a Particular Month
 */
package policymanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static policymanager.PolicyManager.key; 

/**
 * JATIN ANEJA
 * @author w9359412 
 * SCHOOL OF COMPUTING , ENGINEERING AND DIGITAL TECHNOLOGIES
 */
public class PolicySummary_ofSelecetedMonth {

    static int Month_count = 0;      // Global variable

    /*Global method to get Total number of Policies In Each month */
    public static int getMonth_Count(int Month) {
        Month_count = Month;
        return Month_count;
    }

    public static void Display_MyPolicyof_selectedMonth() throws FileNotFoundException, IOException {
        // Menu  for customer to choose to peek their Policy/policies from Archieve File and Current File for a particular month

        System.out.println("(: $$$$ HELLO CUSTOMER $$$$ :)");
        System.out.println("You want to Find your Policy in Current Files Or Our Archieves Files :");
        System.out.println("Please Type A to find data in the Archieves File :");
        System.out.println("Please Type C to Find data in the Current File :\n");
        System.out.print("Enter Your Choice : ");
        String select = key.next();
        key.nextLine();    // bufferLine

        do {
            if (select.equalsIgnoreCase("a")) {
                System.out.println();
                System.out.println("You have Selected Archive Policies\n");
                BufferedReader br = null;
                try {
                    // local instance variables for archieve file
                    String st;
                    float Avg_Mon_Premium = 0;
                    int count = 0, Item_count = 0, temp = 0, Avg_Noofpolicies = 0, num = 0;
                    int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;
                    System.out.print("Please Enter a Particular Month of which the record to be Displayed (example: Jan,Feb etc) : ");
                    String select_Month = key.nextLine();

                    File myfile = new File("Archive.txt");      // file from which data should be extracted
                    
                    br = new BufferedReader(new FileReader(myfile));
                    while ((st = br.readLine()) != null) {
                        String[] s = st.split("\t");   // split the multiple data into a string array
                        if (select_Month.equalsIgnoreCase(s[0].substring(3, 6))) {    // Date in Order - 24-May-2017
                            count++;      // Count total Number of existance only of that particular month
                            getMonth_Count(count);
                            // nested if statements 
                            if (s[6].charAt(0) == 'M' || s[6].charAt(0) == 'A') {
                                Item_count++;
                                temp = Integer.parseInt(s[2]);
                                Avg_Noofpolicies += temp;
                            }
                            if (s[6].charAt(0) == 'M') {
                                num++;
                                temp = Integer.parseInt(String.valueOf(s[5]));    // convert String to Integer type "parseInt(string)"
                                Avg_Mon_Premium += temp;
                            }

                        }// main if ends
                        if (null == s[0].substring(3, 6)) {
                            dec++;
                        } else {
                            /* Switch case to count total Number of Policies for that month */
                            switch (s[0].substring(3, 6)) {
                                case "Jan":
                                    jan++;
                                    break;
                                case "Feb":
                                    feb++;
                                    break;
                                case "Mar":
                                    mar++;
                                    break;
                                case "Apr":
                                    apr++;
                                    break;
                                case "May":
                                    may++;
                                    break;
                                case "Jun":
                                    jun++;
                                    break;
                                case "Jul":
                                    jul++;
                                    break;
                                case "Aug":
                                    aug++;
                                    break;
                                case "Sep":
                                    sep++;
                                    break;
                                case "Oct":
                                    oct++;
                                    break;
                                case "Nov":
                                    nov++;
                                    break;
                                default:
                                    dec++;
                                    break;
                            }
                        }
                    }// while loop ends
                    Avg_Mon_Premium /= num;     // Calculating average Permium of the particular Month
                    Avg_Mon_Premium /= 100;
                    Avg_Noofpolicies /= Item_count;  // Calculating average Number of Items in the Month
                    // displaying data
                    System.out.println("\n$**********************************************************************$");
                    System.out.println("Your Selected Month is : " + select_Month);
                    System.out.println("Total Number of policies of your Selected Month : " + Month_count);
                    System.out.println("Average Number of Items( Accepted policies of your Selected Month) : " + Avg_Noofpolicies);
                    System.out.println("Average Monthly Premium: " + Avg_Mon_Premium);
                    System.out.println("Number of Policies per Month (inc. non-accepted)");
                    System.out.println("Jan  Feb  Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec");
                    System.out.print(jan + "   ");
                    System.out.print(feb + "   ");
                    System.out.print(mar + "   ");
                    System.out.print(apr + "   ");
                    System.out.print(may + "   ");
                    System.out.print(jun + "   ");
                    System.out.print(jul + "   ");
                    System.out.print(aug + "   ");
                    System.out.print(sep + "   ");
                    System.out.print(oct + "   ");
                    System.out.print(nov + "   ");
                    System.out.print(dec + "   ");
                    System.out.println("\n$**********************************************************************$");
                    System.out.println("\n");

                } catch (IOException | NumberFormatException e) {
                } finally {
                    br.close();

                }
            } else if (select.equalsIgnoreCase("c")) {   // User seek to choose from Current Records 
                System.out.println();
                System.out.println("You have Selected to Select from Current Policies\n");
                BufferedReader br = null;
                try {// Local Variables
                    String st;
                    float Avg_Mon_Premium = 0;
                    int count = 0, Item_count = 0, temp = 0, Avg_Noofpolicies = 0, num = 0;
                    int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;
                    System.out.print("Please Enter a Particular Month of which the record to be Displayed (example: Jan,Feb etc) : ");
                    String select_Month = key.nextLine();

                    File myfile = new File("Policy.txt");         // File from which data should be extracted

                    br = new BufferedReader(new FileReader(myfile));
                    while ((st = br.readLine()) != null) {
                        String[] s = st.split("\t");              // split the multiple data into a string array
                        if (select_Month.equalsIgnoreCase(s[0].substring(3, 6))) { // Date in Order - 24-May-2017
                            count++;      // Count total Number of existance only of that particular month
                            getMonth_Count(count);
                            // nested if Statements
                            if (s[6].charAt(0) == 'M' || s[6].charAt(0) == 'A') {
                                Item_count++;
                                temp = Integer.parseInt(s[2]);
                                Avg_Noofpolicies += temp;

                            }
                            if (s[6].charAt(0) == 'M') {
                                num++;
                                temp = Integer.parseInt(String.valueOf(s[5]));// convert String to Integer type "parseInt(string)"
                                Avg_Mon_Premium += temp;
                            }
                        }// main if ends
                        if (null == s[0].substring(3, 6)) {
                            dec++;
                        } else {
                            /* Switch case to count total Number of Policies for that month */
                            switch (s[0].substring(3, 6)) {
                                case "Jan":
                                    jan++;
                                    break;
                                case "Feb":
                                    feb++;
                                    break;
                                case "Mar":
                                    mar++;
                                    break;
                                case "Apr":
                                    apr++;
                                    break;
                                case "May":
                                    may++;
                                    break;
                                case "Jun":
                                    jun++;
                                    break;
                                case "Jul":
                                    jul++;
                                    break;
                                case "Aug":
                                    aug++;
                                    break;
                                case "Sep":
                                    sep++;
                                    break;
                                case "Oct":
                                    oct++;
                                    break;
                                case "Nov":
                                    nov++;
                                    break;
                                default:
                                    dec++;
                                    break;
                            }
                        }
                    }// while Loop ends
                    Avg_Mon_Premium /= num;
                    Avg_Mon_Premium /= 100;
                    Avg_Noofpolicies /= Item_count;
                    // Displaying data
                    System.out.println("\n$**********************************************************************$");
                    System.out.println("Your Selected Month is : " + select_Month);
                    System.out.println("Total Number of policies of your Selected Month : " + Month_count);
                    System.out.println("Average Number of Items( Accepted policies of your Selected Month) : " + Avg_Noofpolicies);
                    System.out.println("Average Monthly Premium: " + Avg_Mon_Premium);
                    System.out.println("Number of Policies per Month (inc. non-accepted)");
                    System.out.println("Jan  Feb  Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec");
                    System.out.print(jan + "   ");
                    System.out.print(feb + "   ");
                    System.out.print(mar + "   ");
                    System.out.print(apr + "   ");
                    System.out.print(may + "   ");
                    System.out.print(jun + "   ");
                    System.out.print(jul + "   ");
                    System.out.print(aug + "   ");
                    System.out.print(sep + "   ");
                    System.out.print(oct + "   ");
                    System.out.print(nov + "   ");
                    System.out.print(dec + "   ");
                    System.out.println("\n$**********************************************************************$");
                    System.out.println("\n");

                } catch (IOException | NumberFormatException e) {
                } finally {
                    br.close();
                }
            } else {
                System.out.println("Enter A or C only!!");
            }
        } while (select.equalsIgnoreCase("a") && select.equalsIgnoreCase("c"));
    }
}
