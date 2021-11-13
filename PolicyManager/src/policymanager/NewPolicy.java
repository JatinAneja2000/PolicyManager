/*
 * Option-1 - Creating New Policis and Saving the Records
 */
package policymanager;
// important java packages 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static policymanager.PolicyManager.key;

/**
 * JATIN ANEJA
 * @author w9359412 
 * SCHOOL OF COMPUTING , ENGINEERING AND DIGITAL TECHNOLOGIES
 */
public class NewPolicy {

    /*
    *           Data Fields (member Variables) 
     */
    static String Clname, reference, date, term, items = null;
    static int gadget_maxVal;
    static boolean append;
    static double Premium = 0, excess, Discounted_Premium = 0;
    static String dummy_numofitem, dummy_term;

    /**
     * getter to get data
     * @return
     */
    public String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf.format(cal.getTime());
    }

    String get_NewDate() {
        return date;
    }

    String getName() {
        return Clname;
    }

    String getRef() {
        return reference;
    }

    String getItems() {
        return items;
    }

    double getexcess() {
        return excess;
    }

    int GetMaxVal() {
        return gadget_maxVal;
    }

    String getTerm() {
        return term;
    }

    double getPremium() {
        return Premium;
    }

    /**
     * Setters to Set new data / change and return
     * @return new Data
     */
    String set_Date(String newdate) {
        return date = newdate;
    }

    String set_Ref(String ref) {
        return reference = ref;
    }

    String set_items(String No_of_Items) {

        if (null == No_of_Items) {
            items = No_of_Items;
        } else {
            switch (No_of_Items) {
                case "1":
                    items = "One";
                    break;
                case "2":
                    items = "Two";
                    break;
                case "3":
                    items = "Three";
                    break;
                case "4":
                    items = "Four";
                    break;
                case "5":
                    items = "Five";
                    break;
                default:
                    items = No_of_Items;
                    break;
            }
        }
        return items;
    }

    static int set_MaxGadget(int max) {
        return gadget_maxVal = max;
    }

    static double set_excess(double Excess) {
        return excess = Excess;
    }

    static double set_premium(double pre) {
        return Premium = pre;
    }

    static String set_term(String newterm) {
        if (newterm.equalsIgnoreCase("m")) {
            return term = "Monthly";
        } else if (newterm.equalsIgnoreCase("a")) {
            return term = "Anually";
        }
        return term = "Rejected Policy";
    }

    static String Set_Name(String name) {
        return Clname = name;
    }

    /**
     * Method to enter a NewPolicy by extracting data from Client and appending
     * it to system database
     * @throws IOException
     */
    public static void getNewPolicy() throws IOException {
        
        NewPolicy policy = new NewPolicy();          /* creating class references*/
         /*Input data from the user along with its valdiation*/
         System.out.println("Hello, Welcome to our company. ");   
        System.out.println("Please Read the instruction given along carefully:)");   

        System.out.println("Policy Date : " + policy.set_Date(policy.getDate()) + "\n");

        System.out.print("Please Enter Your Name (note: First letter of your FirstName + Full LastName(e.g. J Smith): ");
        policy.Clname = key.nextLine().toUpperCase();
        boolean valid_clname = Validation_Policy.valid_name(policy.Clname);
        while (valid_clname == false) {
            System.out.println("Your reference number is invalid  , please Re-Enter : ");
            Clname = key.nextLine().toUpperCase();
            valid_clname = Validation_Policy.valid_name(policy.Clname);    // loop to get Correct data
        }

        System.out.print("\nEnter your Reference Number (note: First Two Letters of your LastName follow by Three Number +letter of LastName(e.g. SI082h) : ");
        policy.reference = key.nextLine().toUpperCase();
        boolean valid_ref = Validation_Policy.valid_Reference(policy.reference, policy.Clname);
        while (valid_ref == false) {
            System.out.println("Your reference number is invalid  , please Re-Enter : ");
            reference = key.nextLine().toUpperCase();
            valid_ref = Validation_Policy.valid_Reference(policy.reference, policy.Clname);
        }  

        System.out.print("\nEnter Number of Items(Maximum items 5) : ");
        NewPolicy.items = key.nextLine();
        dummy_numofitem = policy.items;           // dummy_term to set right data(number) in file without a change (i.e. = 1 not One..)
        items = Validation_Policy.Valid_items(items);

        System.out.print("\nMost expensive gadget value(in pence)(note: maximum value of gadget is 1000 pounds) :  \u00A3");
        policy.gadget_maxVal = key.nextInt();

        System.out.print("\nEnter Excess(note: maximum excess you can pay 40-70pounds to get a discount) : \u00A3");
        policy.excess = key.nextDouble();
        boolean valid_Excess = Validation_Policy.valid_excess(excess);
        while (valid_Excess == false) {
            System.out.println("Your reference number is invalid  , please Re-Enter : ");
            excess = key.nextDouble();
            valid_Excess = Validation_Policy.valid_excess(excess);
        }

        System.out.print("\nPayment Terms (A for annual, M for Monthly)  : ");
        policy.term = key.next().toUpperCase();
        dummy_term = NewPolicy.term;      // dummy_term to set right data(a Letter) in file without a change (i.e. = M not Monthly..)
        String newterm = Validation_Policy.Valid_Term(policy.dummy_numofitem, policy.gadget_maxVal, policy.term);
        dummy_term = newterm;
        set_term(newterm);

        //local
        double premium = Validation_Policy.Premium_Calculator(dummy_numofitem, gadget_maxVal);

        if (premium != -1) {
            policy.Discounted_Premium = Validation_Policy.DisCount_Premium(premium, excess, dummy_term);
            System.out.println("\n***************************************************");
            System.out.println("* Your Premium : " + "\u00A3" + NewPolicy.Discounted_Premium);
            System.out.println("****************************************************");
            policy.Premium = set_premium(policy.Discounted_Premium);
        } else {
            policy.Premium = premium;
        }
        System.out.println();
        Validation_Policy.Summeries(policy);  // display the summary of policy to New customer
        PolicyFileWriter(policy);            // add data to records

    }

    /**
     * Private Method to Write the correct data(in Order) in a Company Records
     * *Policy.txt*
     */
    private static void PolicyFileWriter(NewPolicy policy) throws IOException {

        try {
            //Specifying the file name a
            File file = new File("Policy.txt");

            /* This logic is to create the file if the
                * file is not already present
             */
            if (!file.exists()) {
                file.createNewFile();
            }
            //Here true is to append the content to file
            FileWriter fw = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {//BufferedWriter writer give better performance
                    if (Premium != -1) {
                    Premium *= 100; // in pence
                }
                // extracted data from getnewPolicy() and writing in policy.txt file
                bw.write(policy.getDate() + "\t" + reference + "\t" + dummy_numofitem + "\t" + gadget_maxVal + "\t" + ((int) excess) + "\t" + ((int) Premium) + "\t" + dummy_term + "\t" + Clname);
                bw.newLine();   // entring data in every newline
                bw.close();
                //Closing BufferedWriter Stream
            }
            System.out.println("\nData successfully appended at the end of file ......");

        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
        }
    }

}// NewPolicy Class Ends
