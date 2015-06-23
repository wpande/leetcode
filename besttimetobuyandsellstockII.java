public class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<=1)
            return 0;
        int res=0;
        for(int i=1;i<len;i++)
            res+=(prices[i]>prices[i-1]?prices[i]-prices[i-1]:0);
        return res;
    }
}