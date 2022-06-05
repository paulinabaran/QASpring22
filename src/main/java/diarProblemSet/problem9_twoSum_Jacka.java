package diarProblemSet;

import java.util.HashMap;

public class problem9_twoSum_Jacka {
    public static void main(String[] args){
        int nums[] = new int[]{2,7,11,15};
        reusableMethods.arrayResultPrint(twoSums(nums,9));
    }
    public static int[] twoSums(int[] nums, int target)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ;i <nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
                return new int[]{i, map.get(i)};
            else
                map.put(nums[i],i);
        }
        return nums;
    }
}
