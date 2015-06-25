public class Solution {
    class QuEle{
        int cur;
        List<QuEle> li;
        QuEle(int cur, QuEle prior){
            this.cur=cur;
            li=new ArrayList<QuEle>();
            if(prior!=null)
                li.add(prior);
        }
    }
    
    void backtrace(QuEle buf, StringBuffer sb, List<String> res,int end, String s){
        int len=buf.li.size();
        if(len==0){
            sb.insert(0,s.substring(buf.cur,end));
            String temp=sb.toString();
            if(temp.length()!=0)
                res.add(temp);
            sb.delete(0,end-buf.cur);
            return;
        }
        if(buf.cur!=end){
            sb.insert(0,s.substring(buf.cur,end));
            sb.insert(0," ");
        }
        for(int i=0;i<len;i++)
            backtrace(buf.li.get(i),sb,res,buf.cur,s);
        sb.delete(0,end-buf.cur+1);
    }
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int len=s.length();
        List<String> res=new ArrayList<String>();
        if(len==0||wordDict.size()==0)
            return res;
        boolean[][] con=new boolean[len][len];
        for(int l=0;l<len;l++)
            for(int i=0;i<len-l;i++)
                if(wordDict.contains(s.substring(i,i+l+1)))
                    con[i][i+l]=true;
                else
                    con[i][i+l]=false;
        boolean[] inqu=new boolean[len];
        Queue<QuEle> qu=new LinkedList<QuEle>();
        List<QuEle> lq=new ArrayList<QuEle>();
        for(int i=0;i<len+1;i++)
            lq.add(new QuEle(i,null));
        qu.add(lq.get(0));
        inqu[0]=true;
        StringBuffer sb=new StringBuffer();
        while(!qu.isEmpty()){
            QuEle buf=qu.poll();
            inqu[buf.cur]=false;
            for(int i=buf.cur;i<len;i++)
                if(con[buf.cur][i]){
                    if(i==len-1){
                    	lq.get(len).cur=len;
                    	if(!lq.get(len).li.contains(buf))
                    		lq.get(len).li.add(buf);
                    }
                    else{
                        QuEle temp=lq.get(i+1);
                        if(!temp.li.contains(buf))
                        	temp.li.add(buf);
                        if(!inqu[i+1]){
                        	inqu[i+1]=true;
                            qu.add(temp);
                        }
                    }
                }
        }
        backtrace(lq.get(len),sb,res,len,s);
        return res;
    }
}