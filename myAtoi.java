public class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0)
            return 0;
        boolean sign=true;
        int idx=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='0'&&c<='9'){
                idx=i;
                break;
            }
            if(c=='-'){
                sign=false;
                idx=i+1;
                break;
            }
            if(c=='+'){
                idx=i+1;
                break;
            }
            if(c==' '){
                idx=i+1;
            }
            else
                return 0;
        }
        if(!(str.charAt(idx)>='0'&&str.charAt(idx)<='9'))
            return 0;
        long res=0;
        for(int i=idx;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='0'&&c<='9'){
                res=res*10+(c-'0');
                if(res>Integer.MAX_VALUE)
                    break;
            }
            else
                break;
        }
        int tres=0;
        if(res>Integer.MAX_VALUE||res<0){
            if(sign)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        else
            tres=(int)res;
        return sign?tres:-tres;
    }
}