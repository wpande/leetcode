public class Solution {
     class QuEle implements Comparable<QuEle>{
        int idx;
        int dist;
        QuEle(int idx,int dist){
            this.idx=idx;
            this.dist=dist;
        }
        public int compareTo(QuEle b){
            if(this.dist<b.dist)
                return -1;
            else if(this.dist==b.dist)
                return 0;
            else
                return 1;
        }
    }
    public  int minCut(String s) {
        int len=s.length();
        if(len<=1)
            return 0;
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
        PriorityQueue<QuEle> pq=new PriorityQueue<QuEle>();
        boolean[] visited=new boolean[len];
        ArrayList<QuEle> al=new ArrayList<QuEle>();
        al.add(new QuEle(0,0));
        for(int i=1;i<len;i++){
            QuEle qe=new QuEle(i,Integer.MAX_VALUE);
            al.add(qe);
        }
        pq.add(al.get(0));
        while(!pq.isEmpty()&&!visited[len-1]){
            QuEle buf=pq.poll();
            visited[buf.idx]=true;
            //int ndist=buf.dist+1;
            for(int i=buf.idx;i<len;i++){
                if(ispalin[buf.idx][i]){
                    if(i==len-1){
                        visited[len-1]=true;
                        al.get(len-1).dist=buf.dist;//different from shortest path
                    }
                    else{
                        if(al.get(i+1).dist>buf.dist+1){
                            al.get(i+1).dist=buf.dist+1;
                            pq.add(al.get(i+1));
                        }
                    }
                }
            }
        }
        return al.get(len-1).dist;
    }
}