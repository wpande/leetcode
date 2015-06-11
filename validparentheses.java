public class Solution {
    public boolean isValid(String s) {
        Stack<Character> sc=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                sc.push(c);
            else if(c==')'||c=='}'||c==']'){
                if(sc.empty())
                    return false;
                else{
                    if(c==')'&&sc.peek()=='(')
                        sc.pop();
                    else if(c=='}'&&sc.peek()=='{')
                        sc.pop();
                    else if(c==']'&&sc.peek()=='[')
                        sc.pop();
                    else
                        return false;
                }
            }
        }
        if(sc.empty())
            return true;
        else
            return false;
    }
}