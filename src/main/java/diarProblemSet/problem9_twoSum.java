package diarProblemSet;

import java.util.HashMap;

public class problem9_twoSum {
    public static void main(String[] args){
        int nums[] = new int[]{2,7,11,15};
        reusableMethods.arrayResultPrint(twoSums(nums,9));
    }
    public static int[] twoSums(int[] nums, int target)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ;i <nums.length;i++)
        {
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]),i};
            else
                map.put(target-nums[i],i);
        }
        return nums;
    }
}
