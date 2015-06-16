public class Solution {
    static class CharPos{
        char ch;
        int pos;//for '-',used as cnt
        CharPos(char chr,int po){
            ch=chr;
            pos=po;
        }
    }
    public int longestValidParentheses(String s) {
        Stack<CharPos> st=new Stack<CharPos>();
        int maxlen=0;
        int tcnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push(new CharPos('(',i));
            else{
                if(!st.empty()){
                    CharPos cp=st.pop();
                    if(cp.ch=='-'){
                        tcnt=cp.pos;
                        if(!st.empty()){
                            st.pop();
                            tcnt++;
                            if(!st.empty()&&st.peek().ch=='-')
                                st.peek().pos+=tcnt;
                            else
                                st.push(new CharPos('-',tcnt));
                        }
                        else{
                            if(maxlen<tcnt)
                                maxlen=tcnt;
                        }
                    }
                    else{//'('
                        tcnt=1;
                        if(!st.empty()){
                            if(st.peek().ch=='-')
                                st.peek().pos+=tcnt;
                            else
                                st.push(new CharPos('-',tcnt));
                        }
                        else{
                            st.push(new CharPos('-',tcnt));
                        }
                    }
                }
            }
        }
        while(!st.empty()){
            CharPos cp=st.pop();
            if(cp.ch=='-'&&cp.pos>maxlen)
                maxlen=cp.pos;
        }
        return maxlen*2;
    }
}