public class Solution {
    public String shortestPalindrome(String s) {
        int len=s.length();
        if(len<2)
            return s;
        StringBuffer sb=new StringBuffer(s);
        sb=sb.reverse();
        String rs=sb.toString();
        sb.insert(0,'$');
        sb.insert(0,s);
        String ns=sb.toString();
        len=ns.length();
        int[] kmp=new int[len];
        for(int i=1;i<len;i++){
            int j=kmp[i-1];
            while(j>0&&ns.charAt(i)!=ns.charAt(j)) j=kmp[j-1];
            kmp[i]=j+(ns.charAt(i)==ns.charAt(j)?1:0);
        }
        return rs.substring(0,s.length()-kmp[len-1])+s;
    }
}