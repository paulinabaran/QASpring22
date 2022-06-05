package Day2_042422;

public class whileloop {
    public static void main(String[] args) {
        //iterate through zipcode and streetnumber using linear array and while loop
        String[] zipCodes = new String[]{"11218", "11385", "11456", "11234"};
        int[] houseNumber = new int[]{111, 222, 444, 555};

        //initalize your starting point before calling while loop
        int i = 0;
        //define the end point in while loop
        //length has to be the same for both lists

        while(i < houseNumber.length){
            System.out.println("My zipcode is " + zipCodes[i] + " house number " + houseNumber[i]);


            //incrementing controls your whileloop
            i = i + 1;
        }



    }//end of main




}//end of java class

