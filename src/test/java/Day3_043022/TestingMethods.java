package Day3_043022;

import ReusableClasses.ReusableMethods;

public class TestingMethods {

    public static void main(String[] args) {
        // call the add twonumber method and execute it

        ReusableMethods.addTwoNumbers(20,30);

        //if you want to add more numbers just copy and paste it

        //call the return method and store it in a variable to preform something else (subtract)
        int finalResult = ReusableMethods.subtractTwoNumbers(20,10 );
        System.out.println("new result is " + (finalResult+10));

    }//end of main




}// end of java class
