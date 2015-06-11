public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length&&res!=0;i++){
            int obj=target-nums[i];
            int begin=i+1;
            int end=nums.length-1;
            int m=begin;
            int n=end;
            while(m<=end&&n>=begin&&m<n){
                int tsum=nums[m]+nums[n];
                if(Math.abs(res)>Math.abs(obj-tsum)){
                    res=obj-tsum;
                }
                if(tsum<obj){
                    m++;
                }
                if(tsum>obj){
                    n--;
                }
                if(tsum==obj){
                    res=0;
                    break;
                }
            }
        }
        return target-res;
    }
}