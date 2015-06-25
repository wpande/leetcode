public class Solution {
    public int candy(int[] ratings) {
        int len=ratings.length;
        if(len==0)
            return 0;
        if(len==1)
            return 1;
        int[] ncandy=new int[len];
        int buf=0;
        int cnt=0;
        Stack<Integer> st=new Stack<Integer>();
        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1]){
                ncandy[i]=ncandy[i-1]+1;
                cnt=1;
                while(!st.empty()){
                    buf=st.pop();
                    ncandy[buf]=Math.max(cnt,ncandy[buf]);
                    cnt++;
                }
            }
            else if(ratings[i]==ratings[i-1]){
                cnt=1;
                while(!st.empty()){
                    buf=st.pop();
                    ncandy[buf]=Math.max(cnt,ncandy[buf]);
                    cnt++;
                }
            }
            else{
                st.push(i-1);
                if(len-1==i){
                    st.push(i);
                    cnt=0;
                    while(!st.empty()){
                        buf=st.pop();
                        ncandy[buf]=Math.max(cnt,ncandy[buf]);
                        cnt++;
                    }
                }
            }
        }
        cnt=0;
        for(int i=0;i<len;i++)
            cnt+=ncandy[i];
        return cnt+len;
    }
}