public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length()==0||words.length==0)
            return null;
        List<Integer> res=new ArrayList<Integer>();
        HashMap<String,Integer> hm= new HashMap<String,Integer>();
        HashMap<String,Integer> thm=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++)
            if(hm.containsKey(words[i]))
                hm.put(words[i],hm.get(words[i])+1);
            else
                hm.put(words[i],0);
        int len=words[0].length();
        int slen=s.length();
        int wlen=words.length;
        for(int i=0;i<len;i++){
            int cnt=0;
            int lw=i;
            thm.clear();
            for(int rw=lw+len;rw<=slen;rw+=len){
                String sub=s.substring(rw-len,rw);
                if(hm.containsKey(sub)){
                    if(!thm.containsKey(sub)){
                        thm.put(sub,0);
                        cnt++;
                        if(cnt==wlen){
                            res.add(lw);
                            String removesub=s.substring(lw,lw+len);
                            if(thm.get(removesub)==0)
                                thm.remove(removesub);
                            else
                                thm.put(removesub,thm.get(removesub)-1);
                            lw=lw+len;
                            cnt--;
                        }
                    }
                    else{
                        if(thm.get(sub)<hm.get(sub)){
                            thm.put(sub,thm.get(sub)+1);
                            cnt++;
                            if(cnt==wlen){
                                res.add(lw);
                                String removesub=s.substring(lw,lw+len);
                                if(thm.get(removesub)==0)
                                    thm.remove(removesub);
                                else
                                    thm.put(removesub,thm.get(removesub)-1);
                                lw=lw+len;
                                cnt--;
                            }
                        }
                        else{//move left window
                            String removesub=s.substring(lw,lw+len);
                            while(!removesub.equals(sub)){
                                if(thm.get(removesub)==0)
                                    thm.remove(removesub);
                                else
                                    thm.put(removesub,thm.get(removesub)-1);        
                                cnt--;
                                lw=lw+len;
                                removesub=s.substring(lw,lw+len);
                            }
                            lw=lw+len;
                        }
                    }
                }
                else{
                    lw=rw;
                    cnt=0;
                    thm.clear();
                }
            }
        }
        return res;
    }
}