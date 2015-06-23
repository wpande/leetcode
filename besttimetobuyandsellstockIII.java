public class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<=1)
            return 0;
        if(len==2)
            return prices[0]>=prices[1]?0:prices[1]-prices[0];
        int[] minprices=new int[len];
        int[] maxprices=new int[len];
        for(int i=1;i<len;i++)
            if(i==1)
                minprices[i]=prices[i-1];
            else
                minprices[i]=Math.min(prices[i-1],minprices[i-1]);
        for(int i=len-2;i>=0;i--)
            if(i==len-2)
                maxprices[i]=prices[i+1];
            else
                maxprices[i]=Math.max(prices[i+1],maxprices[i+1]);
        int res=0;
        for(int i=1;i<len;i++){
            res=Math.max(res,prices[i]-minprices[i]);
            minprices[i]=res;
        }
        res=0;
        for(int i=len-2;i>=0;i--){
            res=Math.max(res,maxprices[i]-prices[i]);
            maxprices[i]=res;
        }
        res=0;
        for(int i=1;i<len;i++)
            res=Math.max(res,minprices[i]+maxprices[i]);
        return res;
    }
}