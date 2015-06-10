public class Solution {
    public boolean isPalindrome(int x) {
        if(x==0) return true;
        if(x<0) return false;
        int t=0;
        int cx=x;
        while(x!=0){
            t=t*10+x%10;
            x/=10;
        }
        return cx==t?true:false;
    }
}