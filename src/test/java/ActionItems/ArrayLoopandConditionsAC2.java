package ActionItems;

import java.util.ArrayList;

public class ArrayLoopandConditionsAC2 {
    public static void main(String[] args) {
       //Array List created for all cities

        ArrayList<String> Cities = new ArrayList<>();
        Cities.add("Brooklyn");
        Cities.add("Queens");
        Cities.add("Manhattan");
        Cities.add("Stated Island");

        //for loop created
        for (int i = 0; i < Cities.size(); i++) {
            if (Cities.get(i) == "Brooklyn" || Cities.get(i) == "Manhattan") {
                System.out.println("My city is " + Cities.get(i));

            } //end of print statement
        } // end of for statement




    } // end of main


} // end of java
