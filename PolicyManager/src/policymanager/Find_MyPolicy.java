/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class Find_MyPolicy {

    public static void get_MyPolicy() throws FileNotFoundException, IOException {

        NewPolicy policy = new NewPolicy();

        int linecount = 0;
        System.out.println("(: $$$$ HELLO CUSTOMER $$$$ :)");
        System.out.println("You want to Find your Policy in Current Files Or Archieves Files :");
        System.out.println("Please Type A to Find data in the Archieves File");
        System.out.println("Please type C to find data in the Current File\n");

        System.out.print("Enter your choice : ");
        String select = key.next();
        key.nextLine();
        BufferedReader br = null;
        do {
            if (select.equalsIgnoreCase("a")) {   // Archive Records
                System.out.println();
                System.out.println("You have Selected Archive Policies\n");
                System.out.print("Enter Your Referenec Id :   ");
                String Select_id = key.nextLine();
                try {

                    String st;
                    File myfile = new File("Archive.txt");
                    br = new BufferedReader(new FileReader(myfile));
                    while ((st = br.readLine()) != null) {

                        linecount++;          // no.of lines  
                        String[] s = st.split("\t"); // Spilt each data in string Array 
                        /* displaying data after reading from file */
                        if (Select_id.substring(0).equalsIgnoreCase(s[1].substring(0))) {
                            policy.set_Date(s[0]);
                            policy.set_Ref(s[1]);
                            policy.set_items(s[2]);
                            policy.set_term(s[6]);
                            policy.set_excess(Double.parseDouble(s[4]));// convert String to Integer type "parseInt(string)"
                            policy.set_premium(Double.parseDouble(s[5]) / 100);
                            policy.Set_Name(s[7]);

                            Validation_Policy.Summeries(policy); // Displaying existing data "Archives"
                        }

                    }
                } catch ( NumberFormatException e) {
                    System.out.println("Error : This Policy does Not Exists in the Records!!1");
                } finally {
                    br.close();
                }
            } else if (select.equalsIgnoreCase("c")) {   // Current Records
                System.out.println("You have Selected Current Policies\n");
                System.out.print("Enter Your Referenec Id :   ");
                String Select_id = key.nextLine();
                try {

                    String st;
                    File myfile = new File("Policy.txt");
                    br = new BufferedReader(new FileReader(myfile));
                    while ((st = br.readLine()) != null) {

                        linecount++;// no.of lines  
                        String[] s = st.split("\t");// Spilt each data in string Array 
                        /* displaying data after reading from file */
                        if (Select_id.substring(0).equalsIgnoreCase(s[1].substring(0))) {
                            policy.set_Date(s[0]);
                            policy.set_Ref(s[1]);
                            policy.set_items(s[2]);
                            policy.set_term(s[6]);
                            policy.set_excess(Double.parseDouble(s[4]));// convert String to Integer type "parseInt(string)"
                            policy.set_premium(Double.parseDouble(s[5]) / 100);
                            policy.Set_Name(s[7]);

                            Validation_Policy.Summeries(policy);// Displaying existing data "Current"
                        }

                    }
                } catch ( NumberFormatException e) {
                    System.out.println("Error : This Policy does Not Exists in the Records!!1");
                } finally {
                    br.close();
                }
            } else {
                System.out.println("Enter A or C only!!");
            }
        } while (select.equalsIgnoreCase("a") && select.equalsIgnoreCase("c"));
    }

}
