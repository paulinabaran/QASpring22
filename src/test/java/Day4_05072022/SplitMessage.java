package Day4_05072022;

public class SplitMessage {
    public static void main(String[] args) {
        //declare string variable
        String splitmessage = "My name is John";

        //declaring an array of string to store the string split regex = regular expression//
        //always look for a common expression ex _ or " "
        String [] splitmessageArray = splitmessage.split (" ");

        //print out John to the console by using the split
         System.out.println("My first name is " + splitmessageArray[3]);




    }//end of main to execute statements

}//end of java class
