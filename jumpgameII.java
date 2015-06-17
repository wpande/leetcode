public class Solution {
    public int jump(int[] nums) {
        int len=nums.length;
        int wave=0;
        int res=0;
        if(nums.length<=1)
            return 0;
        int pwave=wave;
        wave=nums[0];
        res++;
        while(wave<len-1){
            int maxwave=wave;
            for(int i=pwave+1;i<=wave;i++)
                if(i+nums[i]>maxwave)
                    maxwave=i+nums[i];
            pwave=wave;
            wave=maxwave;
            res++;
        }
        return res;
    }
}