public class Solution {
    public  int largestRectangleArea(int[] height) {
        int len=height.length;
        if(len<1)
            return 0;
        int res=0;
        int top=0;
        Stack<Integer> st=new Stack<Integer>();
        int i=0;
        for(;i<len;i++)
            if(st.empty()){
                st.push(i);
            }
            else{
                while(!st.empty()){
                    top=st.peek();
                    if(height[top]>=height[i]){
                        top=st.pop();
                        int temp=st.empty()?i:i-st.peek()-1;
                        if(res<height[top]*temp)
                            res=height[top]*temp;
                    }
                    else
                        break;
                }
                st.push(i);
            }
        while(!st.empty()){
            top=st.pop();
            int temp=st.empty()?i:i-st.peek()-1;
            if(res<height[top]*temp)
                res=height[top]*temp;
        }
        return res;
    }
}