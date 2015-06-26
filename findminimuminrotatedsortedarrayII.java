public class Solution {
    public int findMin(int[] nums) {
        int res=nums[0];
        int len=nums.length;
        for(int i=1;i<len;i++)
            if(nums[i]<res)
                res=nums[i];
        return res;
    }
}