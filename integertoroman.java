public class Solution {
    char [][]roman={{'I','V','X'},{'X','L','C'},{'C','D','M'}};
    StringBuffer sb=new StringBuffer();
    public void process(int n,int idx){
        if(n==0)
            return;
        if(n>0&&n<4){
            for(int i=0;i<n;i++)
                sb.append(roman[idx][0]);
        }
        else if(n==4){
            sb.append(roman[idx][0]);
            sb.append(roman[idx][1]);
        }
        else if(n<9){
            n-=5;
            sb.append(roman[idx][1]);
            for(int i=0;i<n;i++)
                sb.append(roman[idx][0]);
        }
        else{
            sb.append(roman[idx][0]);
            sb.append(roman[idx][2]);
        }
    }
    public String intToRoman(int num) {
        while(num>=1000){
            sb.append('M');
            num-=1000;
        }
        int hund=num/100;
        process(hund,2);
        num=num%100;
        int ten=num/10;
        process(ten,1);
        num%=10;
        process(num,0);
        return sb.toString();
    }
}