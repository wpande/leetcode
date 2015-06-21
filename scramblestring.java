public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        if(len1==0&&len2==0)//null string
            return true;
        if(len1!=len2||(len1==1&&s1.charAt(0)!=s2.charAt(0)))
            return false;
        boolean [][][]res=new boolean[len1][len1][len1];
        int l=1;
        for(int i=0;i<len1;i++)
            for(int j=0;j<len1;j++)
                res[i][j][l-1]=(s1.charAt(i)==s2.charAt(j));
        for(l=2;l<=len1;l++)
            for(int i=0;i<len1-l+1;i++)
                for(int j=0;j<len1-l+1;j++)
                    for(int k=0;k<l-1;k++)
                        res[i][j][l-1]|=(res[i][j][k]&&res[i+k+1][j+k+1][l-k-2])||(res[i][j+l-1-k][k]&&res[i+k+1][j][l-k-2]);
        return res[0][0][len1-1];
    }