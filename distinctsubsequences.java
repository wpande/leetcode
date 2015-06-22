public class Solution {
    public int numDistinct(String s, String t) {
        int lens=s.length();
        int lent=t.length();
        int[][] res=new int[lent][lens+1];
        for(int i=lent-1;i>=0;i--){
            char cht=t.charAt(i);
            for(int j=lens-(lent-i);j>=0;j--){
                if(cht==s.charAt(j))
                    res[i][j]=(i==lent-1?1:res[i+1][j+1])+res[i][j+1];
                else
                    res[i][j]=res[i][j+1];
            }
        }
        return res[0][0];
    }	
}