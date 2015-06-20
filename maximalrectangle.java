public class Solution {
    public int solve(int[] histg){
        Stack<Integer> st=new Stack<Integer>();
        int len=histg.length;
        if(len==1)
            return 0;
        int idx=0;
        int ret=0;
        st.push(idx++);
        while(idx<len){
            if(st.empty()||histg[st.peek()]<histg[idx])
                st.push(idx++);
            else{
                while(!st.empty()&&histg[st.peek()]>=histg[idx]){
                    int area=histg[st.pop()]*(st.empty()?idx:idx-st.peek()-1);
                    if(area>ret)
                        ret=area;
                }
            }
        }
        return ret;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int lenx=matrix.length;
        int res=0;
        if(lenx<1)
            return 0;
        int leny=matrix[0].length;
        if(leny<1)
            return 0;
        int[][] hist=new int[lenx+1][leny+1];
        Stack<Integer> st=new Stack<Integer>();
        int buf=0;
        for(int j=0;j<leny;j++)
            for(int i=0;i<lenx+1;i++){
                if(i==lenx){
                    while(!st.empty()){
                        buf=st.pop();
                        hist[buf][j]=i-buf;
                    }
                }
                else{
                    if(matrix[i][j]=='0'){
                        hist[i][j]=0;
                        while(!st.empty()){
                            buf=st.pop();
                            hist[buf][j]=i-buf;
                        }
                    }
                    else{
                        st.push(i);
                    }
                }
            }
        for(int i=0;i<lenx;i++){
            int ret=solve(hist[i]);
            if(ret>res)
                res=ret;
        }
        return res;
    }
}