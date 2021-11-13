/*
 * Class - Option2 -> Peeking into the Records(Archives & Current) and Summarizing the data 
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
public class Policy_Summary {

    public static void Display_MyPolicy() throws FileNotFoundException {

        System.out.println("(: $$$$ HELLO CUSTOMER $$$$ :)");
        System.out.println("You want to Find your Policy in Current Files Or Archieves Files :");
        System.out.println("Please type A to find data in the Archieves File :");
        System.out.println("Please Type C to Find data in the Current File :");
        System.out.print("Enter Your Choice : ");
        String select = key.next();
        key.nextLine();

        do {
            if (select.equalsIgnoreCase("a")) {
                System.out.println();
                System.out.println("You have Selected Archive Policies\n");
                try {
                    int linecount = 0, Mon_count = 0, temp = 0, Avg_Noofpolicies = 0, Item_count = 0;
                    String st;
                    float Avg_Mon_Premium = 0;
                    int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;

                    File myfile = new File("Archive.txt");
                    BufferedReader br = new BufferedReader(new FileReader(myfile));
                    while ((st = br.readLine()) != null) {
                        linecount++;
                        // System.out.println(st);
                        String[] s = st.split("\t");
                        if (s[6].charAt(0) == 'M' || s[6].charAt(0) == 'A') {
                            Item_count++;
                            temp = Integer.parseInt(s[2]);
                            Avg_Noofpolicies += temp;

                        }
                        if (s[6].charAt(0) == 'M') {
                            Mon_count++;
                            temp = Integer.parseInt(s[5]) / 100;
                            Avg_Mon_Premium += temp;
                            // Avg_Mon_Premium /= Mon_count;
                        }
                        if (null == s[0].substring(3, 6)) {
                            dec++;
                        } else {
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

                    }
                    Avg_Mon_Premium /= Mon_count;
                    Avg_Noofpolicies /= Item_count;
                    System.out.println("\n$**********************************************************************$");                      
                    System.out.println("Total Number of policies : " + linecount);
                    System.out.println("Average Number of Items(Accepted policies) : " + Avg_Noofpolicies);
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
                }
            } else if (select.equalsIgnoreCase("c")) {
                System.out.println();
                System.out.println("You have Selected Current Policies\n");

                try {
                    int linecount = 0, Mon_count = 0, temp = 0, Avg_Noofpolicies = 0, Item_count = 0;
                    String st;
                    float Avg_Mon_Premium = 0;
                    int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;

                    File myfile = new File("Policy.txt");
                    BufferedReader br = new BufferedReader(new FileReader(myfile));
                    while ((st = br.readLine()) != null) {
                        linecount++;
                        // System.out.println(st);
                        String[] s = st.split("\t");   // Spliting the string to string Array
                        if (s[6].charAt(0) == 'M' || s[6].charAt(0) == 'A') {
                            Item_count++;
                            temp = Integer.parseInt(s[2]);
                            Avg_Noofpolicies += temp;

                        }
                        if (s[6].charAt(0) == 'M') {
                            Mon_count++;
                            temp = Integer.parseInt(s[5]);// convert String to Integer type "parseInt(string)"
                            Avg_Mon_Premium += temp;

                        }

                        if (null == s[0].substring(3, 6)) {
                            dec++;
                        } else {
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

                    }// While loop ends
                    Avg_Mon_Premium /= Mon_count;
                    Avg_Mon_Premium /= 100;
                    Avg_Noofpolicies /= Item_count;
                    // Displaying Data
                    System.out.println("\n$**********************************************************************$");                    
                    System.out.println("Total Number of policies : " + linecount);
                    System.out.println("Average Number of Items(Accepted policies) : " + Avg_Noofpolicies);
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
                }
            } else {
                System.out.println("Enter A or C Only!!");
            }
        } while (select.equalsIgnoreCase("a") && select.equalsIgnoreCase("c"));

    }
}
