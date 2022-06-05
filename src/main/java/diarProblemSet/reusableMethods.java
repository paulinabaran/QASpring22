package diarProblemSet;

public class reusableMethods {
    public static void arrayResultPrint(int[] nums)
    {
        for(int i = 0; i<nums.length;i++)
        {
            if(i==0)
                System.out.print("{ "+nums[i]+", ");
            else if(i==nums.length-1)
                System.out.print(nums[i]+" }");
            else
                System.out.print(nums[i]+", ");
        }
    }

    public static void arrayResultPrint(char[] nums)
    {
        for(int i = 0; i<nums.length;i++)
        {
            if(i==0)
                System.out.print("{ "+nums[i]+", ");
            else if(i==nums.length-1)
                System.out.print(nums[i]+" }");
            else
                System.out.print(nums[i]+", ");
        }
    }
}
