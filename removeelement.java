public class Solution {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        if(len==0)
            return len;
        for(int i=0;i<len&&len!=0;i++)
            if(nums[i]==val){
                nums[i--]=nums[--len];
            }
        return len;
    }
}