public class Solution {
    public int reverse(int x) {
        boolean sign=true;
        if(x<=Integer.MIN_VALUE)
            return 0;
        if(x<0){
            sign=false;
            x=-x;
        }
        long res=0;
        while(x!=0){
            res=x%10+res*10;
            x/=10;
        }
        if(res>Integer.MAX_VALUE)
            return 0;
        int mres=(int)res;
        return sign?mres:-mres;
    }
}