public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1)
            return;
        int i,j,swap;
        i=nums.length-1;
        j=i-1;
        while(j>=0&&nums[j]>=nums[i]){
            i--;
            j--;
        }
        i=j+1;
        swap =j;
        j=nums.length-1;
        while(i<j){
            nums[i]=nums[i]^nums[j];
            nums[j]=nums[i]^nums[j];
            nums[i]=nums[i]^nums[j];
            i++;
            j--;
        }
        if(swap>=0){
            for(i=swap+1;i<nums.length;i++)
                if(nums[i]>nums[swap]){
                    nums[i]=nums[i]^nums[swap];
                    nums[swap]=nums[i]^nums[swap];
                    nums[i]=nums[i]^nums[swap];
                    break;
                }
        }
    }
}