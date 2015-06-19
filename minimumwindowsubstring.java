public class Solution {
    public String minWindow(String s, String t) {
        int lens=s.length();
        int lent=t.length();
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        int cnt=0;
        HashMap<Character,Integer> thm=new HashMap<Character,Integer>();
        for(int i=0;i<lent;i++){
            char ch=t.charAt(i);
            if(hm.get(ch)!=null){
                Integer buf=hm.get(ch);
                hm.put(ch,buf+1);
            }
            else
                hm.put(ch,1);
        }
        int lw=0;
        int rw=0;
        int slw=0;
        int srw=0;
        int minsize=Integer.MAX_VALUE;
        while(rw<lens){
            char ch=s.charAt(rw);
            rw++;
            if(hm.containsKey(ch)){
                if(thm.get(ch)!=null){
                    int buf=thm.get(ch);
                    thm.put(ch,buf+1);
                }
                else
                    thm.put(ch,1);
                if(thm.get(ch)<=hm.get(ch)){
                    cnt++;
                    if(cnt==lent){
                        while(lw<rw&&cnt==lent){
                            ch=s.charAt(lw);
                            lw++;
                            if(hm.containsKey(ch)){
                                int buf=thm.get(ch);
                                if(hm.get(ch)==buf)
                                    cnt--;
                                if(buf==1)
                                    thm.remove(ch);
                                else
                                    thm.put(ch,buf-1);
                            }
                        }
                        if(rw-lw<minsize){
                            minsize=rw-lw;
                            slw=lw-1;
                            srw=rw;
                        }
                    }
                }
            }
        }
        return s.substring(slw,srw);
    }
}