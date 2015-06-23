public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len3!=len1+len2)
            return false;
        boolean[][] res=new boolean[len1+1][len2+1];
        res[0][0]=true;
        boolean flag=true;
        for(int l=0;l<len1+len2+1&&flag;l++){
            flag=false;
            for(int i=0;i<=l&&i<=len1;i++){
                int j=l-i;
                if(j<=len2&&res[i][j]){
                    if(j==len2&&i<len1){
                        res[i+1][j]=s1.charAt(i)==s3.charAt(l);
                        flag|=res[i+1][j];
                    }
                    else if(i==len1&&j<len2){
                        res[i][j+1]=s2.charAt(j)==s3.charAt(l);
                        flag|=res[i][j+1];                        
                    }
                    else if(i<len1&&j<len2){
                        res[i+1][j]=s1.charAt(i)==s3.charAt(l);
                        res[i][j+1]=s2.charAt(j)==s3.charAt(l);
                        flag|=res[i+1][j]||res[i][j+1];
                    }
                }
            }
        }
        return res[len1][len2];
    }
}