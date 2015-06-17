public class Solution {
    public boolean isMatch(String s, String p) {
        int lens=s.length();
        int lenp=p.length();
        if(lens==0&&lenp==0)
            return true;
        int ps=0;
        int pp=0;
        int tps=-1;
        int tpp=-1;
        while(ps<lens){
            if(pp<lenp&&(p.charAt(pp)=='?'||p.charAt(pp)==s.charAt(ps))){
                ps++;
                pp++;
            }
            else if(pp<lenp&&p.charAt(pp)=='*'){
                tps=ps;
                tpp=pp;
                pp++;
            }
            else{
                if(tpp>=0){
                    ps=tps+1;
                    pp=tpp+1;
                    tps=ps;
                }
                else
                    return false;
            }
        }
        boolean flag=true;
        while(pp<lenp&&flag){ 
            if(p.charAt(pp++)!='*')
                flag=false;
            } 
        return flag;
    }
}