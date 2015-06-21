public class Solution {
    boolean setequal(String s1, String s2){
        int len1=s1.length();
        int len2=s2.length();
        if(len1!=len2)
            return false;
        HashMap<Character, Integer> hm1=new HashMap<Character, Integer>();
        HashMap<Character, Integer> hm2=new HashMap<Character, Integer>();
        for(int i=0;i<len1;i++){
            char ch=s1.charAt(i);
            if(hm1.containsKey(ch))
                hm1.put(ch,hm1.get(ch)+1);
            else
                hm1.put(ch,1);
            ch=s2.charAt(i);
            if(hm2.containsKey(ch))
                hm2.put(ch,hm2.get(ch)+1);
            else
                hm2.put(ch,1);
        }
        return hm1.equals(hm2);
    }
    
    public boolean isScramble(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        if(len1==0&&len2==0)//null string
            return true;
        if(len1!=len2||(len1==1&&s1.charAt(0)!=s2.charAt(0))||(!setequal(s1,s2)))
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