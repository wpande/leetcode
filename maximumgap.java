public class Solution {
    public int maximumGap(int[] nums) {
        int len=nums.length;
        if(len<2)
            return 0;
        int max=nums[0];
        int min=max;
        for(int i=1;i<len;i++){
            max=nums[i]>max?nums[i]:max;
            min=nums[i]<min?nums[i]:min;
        }
        int range=max-min+1;
        int bucketlen=range/len+1;
        int[][] bucket=new int[len][2];
        for(int i=0;i<len;i++){
            int idx=(nums[i]-min)/bucketlen;
            bucket[idx][0]=bucket[idx][0]==0?nums[i]:Math.min(bucket[idx][0],nums[i]);
            bucket[idx][1]=Math.max(bucket[idx][1],nums[i]);
        }
        int res=0;
        int prior=bucket[0][1];//min exists no need to check !=0 as the next two lines
        for(int i=1;i<len;i++){
            if(bucket[i][0]!=0){
                res=Math.max(res,bucket[i][0]-prior);
                prior=bucket[i][1];
            }
        }
        return res;
    }
}