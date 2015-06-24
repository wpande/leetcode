public class Solution {
    List<List<String>>  res=new ArrayList<List<String>>();
    
    void recurpar(String s, boolean[][] ispalin, List<String> ls, int start){
        if(start==s.length()){
            List<String> nls=new ArrayList<String>(ls);
            res.add(nls);
            return;
        }
        for(int i=start;i<s.length();i++)
            if(ispalin[start][i]){
                ls.add(s.substring(start,i+1));
                recurpar(s,ispalin,ls,i+1);
                ls.remove(ls.size()-1);
            }
    }

    public List<List<String>> partition(String s) {
        int len=s.length();
        List<String> ls=new ArrayList<String>();
        if(len<=1){
            ls.add(s);
            res.add(ls);
            return res;
        }
        boolean[][] ispalin=new boolean[len][len];
        for(int l=1;l<=len;l++)
            for(int i=0;i<len-l+1;i++){
                if(l==1){
                    ispalin[i][i]=true;
                }
                else{
                    if(l%2==0){
                        if(s.charAt(i)==s.charAt(i+l-1)&&(l==2||ispalin[i+1][i+l-2]))
                            ispalin[i][i+l-1]=true;
                        else
                            ispalin[i][i+l-1]=false;
                    }
                    else{
                        if(s.charAt(i)==s.charAt(i+l-1)&&ispalin[i+1][i+l-2])
                            ispalin[i][i+l-1]=true;
                        else
                            ispalin[i][i+l-1]=false;
                    }
                }
            }
        
        recurpar(s,ispalin,ls,0);
        return res;
    }
}