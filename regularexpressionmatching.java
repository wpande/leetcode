public class Solution {
    public boolean isMatch(String s, String p) {
        int lens=s.length();
        int lenp=p.length();
        boolean[][] match=new boolean[lens+1][lenp+1];
        match[0][0]=true;
        for(int j=1;j<=lenp;j++){
            for(int i=0;i<=lens;i++){
                if(match[i][j-1]){
                    if(p.charAt(j-1)=='*'||(j<lenp&&p.charAt(j)=='*'))
                        match[i][j]=true;
                }
                if(i>0&&match[i-1][j-1]){
                    if(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.'||(p.charAt(j-1)=='*'&&(j-1)>0&&(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1))))
                       match[i][j]=true;
                }
                if(p.charAt(j-1)=='*'&&i>0&&match[i-1][j]){
                    if(j>1&&(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1)))
                        match[i][j]=true;
                }
            }
        }
        return match[lens][lenp];
    }
}