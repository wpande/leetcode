public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int lenx=dungeon.length;
        int leny=dungeon[0].length;
        int[][]res =new int[lenx+1][leny+1];
        for(int i=0;i<leny;i++)
            res[lenx][i]=Integer.MAX_VALUE;
        for(int i=0;i<lenx;i++)
            res[i][leny]=Integer.MAX_VALUE;
        res[lenx][leny-1]=1;
        res[lenx-1][leny]=1;
        for(int s=lenx+leny-2;s>=0;s--)
            for(int i=lenx-1;i>=0;i--){
                int j=s-i;
                if(j>=0&&j<leny){
                    res[i][j]=Math.min(res[i][j+1],res[i+1][j])-dungeon[i][j];
                    res[i][j]=Math.max(res[i][j],1);
                }
            }
        return res[0][0];
    }
}