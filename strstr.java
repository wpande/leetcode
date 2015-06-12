public class Solution {
    int[] fneedle(String needle){
        int len=needle.length();
        int[] fn=new int[len];
        for(int i=0;i<len;i++)
            fn[i]=i-1;//begin at -1
        for(int i=1;i<len;i++){
            int j=i-1;
            while(fn[j]>=0&&needle.charAt(fn[j])!=needle.charAt(i-1)) j=fn[j];
            fn[i]=fn[j]+1;
        }
        return fn;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()<1)
            return 0;
        if(haystack.length()<1)
            return -1;
        int i=0;
        int j=0;
        int res=-1;
        int[] fn=fneedle(needle);
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()){
                    res=i-j;
                    break;
                }
            }
            else{
                j=fn[j];
                if(j<0){
                    j=0;
                    i++;
                }
            }
        }
        return res;
    }
}