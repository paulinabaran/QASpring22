package ActionItems;

public class whileloopAC1 {

    public static void main(String[] args) {
        //creating string array for region
        String[] region = new String[]{" Asia ", " the Mediterranean ", " Central Europe ", " Africa "};
        //creating int array for areaCode
        int[] areaCode = new int[]{11567, 88983, 65432, 55678};

        //italizing starting point of while loop
        int i=0;

        while(i < region.length)

        {
            System.out.println(" My region is" + region[i] + "and my area code is " + areaCode[i]);

        //incrementing for while loop
        i=i +1;
        }


    }//end of main class






}//end of java class
