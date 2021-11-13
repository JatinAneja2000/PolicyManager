/**
 * Class - 1) To validate the data entered by the User
 *         2) Calculate the Premium according to the user Data
 *         3) Display the Summary of the policies Option1 and Option4 of the Prototype
 */
package policymanager;

/**
 * JATIN ANEJA
 * @author w9359412 
 * SCHOOL OF COMPUTING , ENGINEERING AND DIGITAL TECHNOLOGIES
 */
public class Validation_Policy {

    /**
     * Validating Client's Data - Name , Reference Number , Term
     * @return
     */
    
    protected static boolean valid_name(String name) {
        //client's name should not exceed 20 characters
        return name.length() <= 20;
    }

    protected static boolean valid_Reference(String reference, String name) {
        // Reference number is 1st two letters of the last-Name preceed by 3 numbers and a letter 
        String str = reference.substring(2, 5);
        int num = Integer.parseInt(str);
        return (reference.charAt(0) == name.charAt(2)) && (reference.charAt(1) == name.charAt(3)) && (num >= 000 || num <= 999) && (reference.charAt(5) >= 'A' || reference.charAt(5) <= 'Z');
    }

    protected static String Valid_Term(String item, int maxval, String Term) {
        // if items are in range 1-5  or maxgadget value is less than 1000
        // polciy accepeted
        int item_num = Integer.parseInt(item);
        if ((item_num >= 1 && item_num <= 5) && maxval < 1000) {
            return Term;
        }
        // else rejected
        return Term = "R";

    }
    protected static boolean valid_excess(double Excess){
        return Excess <= 70;
    } 

    protected static String Valid_items(String items) {
        int item_num = Integer.parseInt(items);
        if (item_num >= 1 && item_num <= 5) {
            switch (items) {
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

            }
            return items;
        }
        return items;

    }

    /**
     * calculating Premium for every customer and displaying
     *
     * @param NumberOfitems
     * @param gadget_MaxVal
     * @return
     */
    protected static double Premium_Calculator(String NumberOfitems, int gadget_MaxVal) {
        double Premium = 0;    // local
        int num = Integer.parseInt(NumberOfitems);
        if (num == 1 && gadget_MaxVal <= 500) {
            Premium = 5.99;
        } else if ((num >= 2 && num <= 3) && gadget_MaxVal <= 500) {
            Premium = 10.99;
        } else if ((num >= 4 && num <= 5) && gadget_MaxVal <= 500) {
            Premium = 15.99;
        } else if (num == 1 && (gadget_MaxVal > 500 && gadget_MaxVal <= 800)) {
            Premium = 7.15;
        } else if ((num >= 2 && num <= 3) && (gadget_MaxVal > 500 && gadget_MaxVal <= 800)) {
            Premium = 13.35;
        } else if ((num >= 4 && num <= 5) && (gadget_MaxVal > 500 && gadget_MaxVal <= 800)) {
            Premium = 19.60;
        } else if (num == 1 && (gadget_MaxVal > 800 && gadget_MaxVal <= 1000)) {
            Premium = 8.30;
        } else if ((num >= 2 && num <= 3) && (gadget_MaxVal > 800 && gadget_MaxVal <= 1000)) {
            Premium = 15.55;
        } else if ((num >= 4 && num <= 5) && (gadget_MaxVal > 800 && gadget_MaxVal <= 1000)) {
            Premium = 22.82;
        } else {
            Premium = -1;
        }
        //System.out.println(Premium);
        return Premium;
    }

    protected static double DisCount_Premium(double Premium, double excess, String term) {
        if ("A".equals(term)) {
            Premium *= 12;
            switch ((int) excess) {
                case 40:
                    Premium -= (Premium * 0.15);
                    break;
                case 50:
                    Premium -= (Premium * 0.20);
                    break;
                case 60:
                    Premium -= (Premium * 0.25);
                    break;
                case 70:
                    Premium -= (Premium * 0.30);
                    break;
                default:
                    Premium -= (Premium * 0.10);
                    break;
            }
        } else {
            switch ((int) excess) {
                case 40:
                    Premium -= (Premium * 0.05);
                    break;
                case 50:
                    Premium -= (Premium * 0.10);
                    break;
                case 60:
                    Premium -= (Premium * 0.15);
                    break;
                case 70:
                    Premium -= (Premium * 0.20);
                    break;
                default:
                    Premium = Premium;
                    break;
            }
        }
        return Premium;
    }

    /**
     * Displaying Summary of New Policies and Old Policies
     * @param newPolicy
     */
    public static void Summeries(NewPolicy newPolicy) {

        System.out.printf("+=============================================+\n");
        System.out.printf("|                                             |\n");
        System.out.printf("|  Client's Name: %12s                |\n", newPolicy.getName());
        System.out.printf("|                                             |\n");
        System.out.printf("|    Date: %8s   Ref: %5s          |\n", newPolicy.get_NewDate(), newPolicy.getRef());
        System.out.printf("|   Terms: %10s     Items: %4s         |\n", newPolicy.getTerm(), newPolicy.getItems());
        System.out.printf("|  Excess: £%.2f                             |\n", newPolicy.getexcess());
        System.out.printf("|                                             |\n");
        System.out.printf("|  %10s          Limit per              |\n", newPolicy.getTerm());
        System.out.printf("| Premium: £%2f     Gadget:1000        |\n", newPolicy.getPremium());
        System.out.printf("|                                             |\n");
        System.out.printf("+=============================================+\n");

    }

}
