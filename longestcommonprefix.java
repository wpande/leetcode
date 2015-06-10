public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int numofstr=strs.length;
        int i=0;
        if(numofstr==0)
            return "";
        int strlen=strs[0].length();
        for(i=1;i<numofstr;i++){
            int tlen=strs[i].length();
            if(strlen>tlen)
                strlen=tlen;
        }
        boolean flag=true;
        for(i=0;i<strlen&&flag;i++)
            for(int j=0;j<numofstr-1;j++)
                if(strs[j].charAt(i)!=strs[j+1].charAt(i))
                    flag=false;
        if(i==0)
            return "";
        else{
            if(flag)
                return strs[0].substring(0,i);
            else
                return strs[0].substring(0,i-1);
        }
    }
}