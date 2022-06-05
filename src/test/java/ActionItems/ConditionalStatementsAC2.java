package ActionItems;

public class ConditionalStatementsAC2 {

    public static void main(String[] args) {

        //declaring grade integer values
        int Grade = 90;

        //print alphabetical values of grades depending on integer value

        if (Grade >= 90 && Grade <= 100) {
            System.out.println("Grade is A ");
        } else if (Grade >= 80 && Grade < 90) {
            System.out.println("Grade is B ");
        } else if (Grade >= 70 && Grade < 80) {
            System.out.println("Grade is C ");
        } else if (Grade >= 60 && Grade < 70) {
            System.out.println("Grade is D ");
        } else {
            System.out.println("Grade is F");
        } // end of multiple conditional satements

    } //end of main


    } // end of java class
