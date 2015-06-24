public class Solution {
    class LinkedStr{
        String str;
        List<LinkedStr> priorset;
        LinkedStr(String str, LinkedStr prior){
            this.str=str;
            if(prior==null)
                this.priorset=null;
            else{
                this.priorset=new ArrayList<LinkedStr>();
                this.priorset.add(prior);
            }
        }
    }
    
    void backtrace(LinkedStr ls, ArrayList<String> li, List<List<String>> res){	
    	li.add(0,ls.str);
        if(ls.priorset==null){
        	List<String> nli=new ArrayList<String>(li);
            res.add(nli);
            li.remove(0);
            return;
        }
        int len=ls.priorset.size();
        for(int i=0;i<len;i++){
            LinkedStr buf=ls.priorset.get(i);
            backtrace(buf,li,res);
        }
        li.remove(0);
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Queue<LinkedStr> qu=new LinkedList<LinkedStr>();
        List<List<String>>  res=new ArrayList<List<String>>();
        LinkedStr blank=new LinkedStr("",null);
        LinkedStr thrhead=new LinkedStr(start,null);
        dict.add(end);
        dict.remove(start);
        int len=start.length();
        int level=0;
        int stoplev=Integer.MAX_VALUE;
        qu.add(thrhead);
        qu.add(blank);
        HashMap<String,LinkedStr> hm=new HashMap<String,LinkedStr>();
        ArrayList<String> li=new ArrayList<String>();
        while(!qu.isEmpty()&&level<stoplev){
            LinkedStr ls=qu.poll();
            String cur=ls.str;
            if(!cur.equals("")){
                char[] chars=cur.toCharArray();
                dict.remove(cur);
                for(int i=0;i<len;i++){
                    char temp=chars[i];
                    for(char ch='a';ch<='z';ch++){
                        if(ch!=temp){
                            chars[i]=ch;
                            String nstr=String.valueOf(chars);
                                if(dict.contains(nstr)){
                                    if(nstr.equals(end)){
                                        stoplev=level+1;
                                        li.add(0,nstr);
                                        backtrace(ls,li,res);
                                        li.remove(0);
                                    }
                                    else{
                                        dict.remove(nstr);
                                        LinkedStr nls=new LinkedStr(nstr,ls);
                                        hm.put(nstr,nls);
                                        qu.add(nls);
                                    }
                                }
                                else{
                                    if(hm.containsKey(nstr)){
                                        LinkedStr buf=hm.get(nstr);
                                        buf.priorset.add(ls);
                                    }
                                }
                        }
                    }
                    chars[i]=temp;
                }
                if(!cur.equals(end))
                    dict.remove(cur);
            }
            else{
                if(!qu.isEmpty()){
                    hm.clear();
                    level++;
                    qu.add(blank);
                }
            }
        }
        return res;
    }
}