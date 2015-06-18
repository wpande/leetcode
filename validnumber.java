public class Solution {
    boolean isN(String s){
        if(s.length()<1)
            return false;
        if(s.length()==1&&s.charAt(0)=='.')
            return false;
        int cntdot=0;
        int begin=0;
        if(s.charAt(begin)=='+'||s.charAt(begin)=='-')
            begin++;
        boolean res=false;
        for(int i=begin;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='.'){
                cntdot++;
                if(cntdot>1)
                    return false;
            }
            else if(ch>='0'&&ch<='9')
                res=true;
            else
                return false;
        }
        return res;
    }
    
    boolean isIN(String s){
        if(s.length()<1)
            return false;
        if(s.length()==1&&s.charAt(0)=='.')
            return false;
        int begin=0;
        if(s.charAt(begin)=='+'||s.charAt(begin)=='-')
            begin++;
        boolean res=false;
        for(int i=begin;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='.')
                return false;
            else if(ch>='0'&&ch<='9')
                res=true;
            else
                return false;
        }
        return res;
    }
    
    public boolean isNumber(String s) {
        s=s.trim();
        if(s.length()<1)
            return false;
        int eidx=s.indexOf('e');
        if(eidx==-1)
            return isN(s);
        else
            return isN(s.substring(0,eidx))&&isIN(s.substring(eidx+1));
    }
}