public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int idx=0;
        for(int i=1;i<nums.length;i++)
            if(nums[idx]!=nums[i])
                nums[++idx]=nums[i];
        return idx+1;
    }
}