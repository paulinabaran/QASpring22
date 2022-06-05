package Day3_043022;

import java.util.ArrayList;

public class if_else_with_loop {
    public static void main(String[] args) {
        //create and array with fruits print only when fruit is apple or orange
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("grape");
        fruits.add("strawberry");

        for (int i = 0; i < fruits.size(); i++) {
           if(fruits.get(i) == "apple"|| fruits.get(i) == "grape"){
               System.out.println("My fruit is " + fruits.get(i));
           }

        }// end of for loop



   // w/o operator
        /*
   if(fruits.get(i) == "apple"){
              System.out.println("My fruit is " + fruits.get(i));
           } else if (fruits.get(i) == "grape") {
                System.out.println("My fruit is " + fruits.get (i))
                          }
        */





    }// end of main


}//end of java class

