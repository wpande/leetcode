public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0)
            return Integer.MAX_VALUE;
        boolean sign=((dividend ^ divisor)>>31)==0?true:false;
        if(sign&&divisor==-1&&dividend==Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        if(divisor==Integer.MIN_VALUE){
            if(dividend==Integer.MIN_VALUE)
                return 1;
            else
                return 0;
        }
        else
            divisor=Math.abs(divisor);
        int res=0;
        if(dividend==Integer.MIN_VALUE){
            res++;
            dividend+=divisor;
        }
        dividend=Math.abs(dividend);
        int shift=0;
        while((dividend>>1)>=(divisor<<shift)) shift++;
        while(shift>-1){
            if(dividend>=(divisor<<shift)){
                dividend=dividend-(divisor<<shift);
                res=res+(1<<shift);
            }
            shift--;
        }
        return sign?res:-res;
    }
}