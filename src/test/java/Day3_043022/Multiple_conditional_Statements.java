package Day3_043022;

public class Multiple_conditional_Statements {
    public static void main(String[] args) {
        int a = 1;
        int b= 2;
        int c = 3;

        //if a+b < than c then print the result
        //if a + b > than c then print the result
        //finally print a+b is equal to c

        if(a + b < c){
            System.out.println(" a & b is less than c");
        } else if (a + b > c) {
            System.out.println(" a & b is greater than c");
        } else if (a + b == c) {
            System.out.println("a & b are equal to c");
        }// end of conditions


    }//end of main


}//end of java class
