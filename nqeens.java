public class Solution {
    List<String[]> res=new ArrayList<String[]>();
    void solve(boolean[] row,boolean[] col,boolean[] lcross,boolean[] rcross,int[] pos,int idx){
        if(idx==row.length){
            StringBuffer sb=new StringBuffer();
            String[] ss=new String[idx];
            for(int i=0;i<idx;i++){
                sb.setLength(0);
                for(int j=0;j<idx;j++)
                    if(j!=pos[i])
                        sb.append('.');
                    else
                        sb.append('Q');
                ss[i]=sb.toString();
            }
            res.add(ss);
            return;
        }
        for(int i=0;i<row.length;i++){
            if(!col[i]&&!row[idx]&&!lcross[i+idx]&&!rcross[row.length-1+i-idx]){
                pos[idx]=i;
                col[i]=true;
                row[idx]=true;
                lcross[i+idx]=true;
                rcross[row.length-1+i-idx]=true;
                solve(row,col,lcross,rcross,pos,idx+1);
                col[i]=false;
                row[idx]=false;
                lcross[i+idx]=false;
                rcross[row.length-1+i-idx]=false;                
            }
        }
    }
    public List<String[]> solveNQueens(int n) {
        boolean[] row=new boolean[n];
        boolean[] col=new boolean[n];
        boolean[] lcross=new boolean[2*n-1];
        boolean[] rcross=new boolean[2*n-1];
        int[] pos=new int[n];
        solve(row,col,lcross,rcross,pos,0);
        return res;
    }
}