public class Solution {
    List<String> ls=new ArrayList<String>();
    Stack<Character> s=new Stack<Character>();
    void generate(char[] par,int lcnt,int rcnt, int idx){
        if(idx==par.length){
            ls.add(String.valueOf(par));
        }
        if(lcnt>0){
            par[idx]='(';
            s.push('(');
            generate(par,lcnt-1,rcnt,idx+1);
            s.pop();
        }
        if(rcnt>0){
            if(!s.empty()&&s.peek()=='('){
                par[idx]=')';
                s.pop();
                generate(par,lcnt,rcnt-1,idx+1);
                s.push('(');
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        char []par =new char[2*n];
        generate(par,n,n,0);
        return ls;
    }
}