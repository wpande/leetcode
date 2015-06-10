public class Solution {
    public int romanToInt(String s) {
        int res=0;
        int lens=s.length();
        int i=0;
        while(i<lens&&s.charAt(i)=='M'){
            i++;
            res+=1000;
        }
        while(i<lens&&s.charAt(i)=='C'){
            if(i+1<lens){
                if(s.charAt(i+1)=='M'){
                    res+=900;
                    i+=2;
                }
                else if(s.charAt(i+1)=='D'){
                    res+=400;
                    i+=2;
                }
                else{
                    i++;
                    res+=100;
                }
            }
            else{
                i++;
                res+=100;
            }
        }
        if(i<lens&&s.charAt(i)=='D'){
            i++;
            res+=500;
        }
        while(i<lens&&s.charAt(i)=='C'){
            i++;
            res+=100;
        }
        while(i<lens&&s.charAt(i)=='X'){
            if(i+1<lens){
                if(s.charAt(i+1)=='C'){
                    res+=90;
                    i+=2;
                }
                else if(s.charAt(i+1)=='L'){
                    res+=40;
                    i+=2;
                }
                else{
                    i++;
                    res+=10;
                }
            }
            else{
                i++;
                res+=10;               
            }
        }
        if(i<lens&&s.charAt(i)=='L'){
            i++;
            res+=50;
        }
        while(i<lens&&s.charAt(i)=='X'){
            i++;
            res+=10;
        }    
        while(i<lens&&s.charAt(i)=='I'){
            if(i+1<lens){
                if(s.charAt(i+1)=='X'){
                    res+=9;
                    i+=2;
                }
                else if(s.charAt(i+1)=='V'){
                    res+=4;
                    i+=2;
                }
                else{
                    i++;
                    res+=1;
                }
            }
            else{
                i++;
                res+=1;
            }
        }
        if(i<lens&&s.charAt(i)=='V'){
            i++;
            res+=5;
        }
        while(i<lens&&s.charAt(i)=='I'){
            i++;
            res+=1;
        } 
        return res;
    }
}