public class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<1)
            return 0;
        int[] minprices=new int[len];
        for(int i=1;i<len;i++)
            if(i==1)
                minprices[i]=prices[i-1];
            else
                minprices[i]=Math.min(prices[i-1],minprices[i-1]);
        int res=0;
        for(int i=1;i<len;i++)
            res=Math.max(res,prices[i]-minprices[i]);
        return res;
    }
}