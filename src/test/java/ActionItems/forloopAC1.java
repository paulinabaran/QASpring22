package ActionItems;

import java.util.ArrayList;

public class forloopAC1 {
    public static void main(String[] args) {
//create an array list for countries using String
        ArrayList<String> Country = new ArrayList<>();
        Country.add("Italy");
        Country.add("Spain");
        Country.add("Poland");
        Country.add("Albania");

//create and array list for the country code using int
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1234);
        countryCode.add(1235);
        countryCode.add(1333);
        countryCode.add(4567);

//using loop to look through all values
        for (int p = 0; p < 3; p++) {

//printing information from String and int
            System.out.println(" My country is " + Country.get(p) + " and my country code is " + countryCode.get(p));

        } //end of print fc





        }  //end of main method




}//end of java class
