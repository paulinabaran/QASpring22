package Day2_042422;

import java.util.ArrayList;

public class forLoop {
    public static void main(String[] args) {
        //create an array list for cities and look through all the values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Long Island");



        //inti i= 0 (starting point), i < cities.size() (gate keeper numeric digit of amount of ArrayList), i++ (i=0+1)
        for (int i = 0; i < cities.size(); i++)
        {

            System.out.println("My city is " + cities.get(i));


        }//end of forloop





    }//end of main




}//end of java class
