public class Solution {
    public int trap(int[] height) {
        if(height.length<1)
            return 0;
        int len=height.length;
        int[] maxr=new int[len];
        int[] maxl=new int[len];
        maxr[len-1]=height[len-1];
        for(int i=len-2;i>=0;i--)
            maxr[i]=Math.max(height[i+1],maxr[i+1]);
        maxl[0]=height[0];
        for(int i=1;i<len;i++)
            maxl[i]=Math.max(height[i-1],maxl[i-1]);
        int res=0;
        for(int i=1;i<len;i++){
            int minh=Math.min(maxl[i],maxr[i]);
            if(height[i]<minh)
                res+=minh-height[i];
        }
        return res;
    }
}