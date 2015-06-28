public class Solution {
    public int maxProfit(int k, int[] prices) {
        //learnt from others's code
        int len=prices.length;
        int res=0;
        if(k>=len){
            for(int i=0;i<len;i++){
               int dif=i==0?0:prices[i]-prices[i-1];
               res=res+(dif>0?dif:0);
            }
            return res;
        }
        int[][] global=new int[len+1][k+1];
        int[][] local=new int[len+1][k+1];
        for(int i=1;i<=len;i++){
            int dif=i==1?0:prices[i-1]-prices[i-2];
            int upper=Math.min(i,k);
            for(int j=1;j<=upper;j++){
                local[i][j]=Math.max(local[i-1][j]+dif,global[i-1][j-1]+Math.max(dif,0));
                global[i][j]=Math.max(local[i][j],global[i-1][j]);
            }
        }
        return global[len][k];
    }
}