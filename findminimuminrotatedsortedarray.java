public class Solution {
    public int findMin(int[] nums) {
        int res=nums[0];
        int len=nums.length;
        if(res<nums[len-1])
            return res;
        int begin=1;
        int end=len-1;
        while(begin<=end){
            int mid=(begin+end)/2;
            if(nums[mid]>res)
                begin=mid+1;
            else{//no equal <
                res=nums[mid];
                end=mid-1;
            }
        }
        return res;
    }
}