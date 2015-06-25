public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len=s.length();
        if(len==0){
            if(wordDict.contains(""))
                return true;
            else
                return false;
        }
        boolean res=false;
        boolean[][] con=new boolean[len][len];
        for(int l=0;l<len;l++)
            for(int i=0;i<len-l;i++)
                if(wordDict.contains(s.substring(i,i+l+1)))
                    con[i][i+l]=true;
                else
                    con[i][i+l]=false;
        boolean[] connected=new boolean[len];
        connected[0]=true;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++)
                if(connected[i]&&con[i][j]){
                    if(j==len-1)
                        return true;
                    else
                        connected[j+1]=true;
                }
        }
        return res;
    }
}