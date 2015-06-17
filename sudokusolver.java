public class Solution {
    boolean [][]rowhs=new boolean[9][9];
    boolean [][]colhs=new boolean[9][9];
    boolean [][]blockhs=new boolean[9][9];
    char []cs={'1','2','3','4','5','6','7','8','9'};//charset
    boolean cont=true;
    void iniths(char [][]board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    rowhs[i][(board[i][j]-'1')]=true;
                    colhs[j][(board[i][j]-'1')]=true;
                    blockhs[(i/3)*3+(j/3)][(board[i][j]-'1')]=true;
                }
            }
        }
    }
    
	void solve(char[][] board, int x, int y){
        int bidx=(x/3)*3+(y/3);
        if(board[x][y]!='.'){
            if(x==8&&y==8){
                cont=false;
                {
                	for(int p=0;p<9;p++){
                		System.out.println();
                		for(int q=0;q<9;q++)
                			System.out.print(board[p][q]);
                	}
                }
                return;
            }
            if(y<8)
                solve(board,x,y+1);
            else
                solve(board,x+1,0);     
            return;
        }
        else{
        for(int i=0;i<9&&cont;i++){
            if(!rowhs[x][(cs[i]-'1')]&&!colhs[y][(cs[i]-'1')]&&!blockhs[bidx][(cs[i]-'1')]){
                rowhs[x][(cs[i]-'1')]=true;
                colhs[y][(cs[i]-'1')]=true;
                blockhs[bidx][(cs[i]-'1')]=true;
                board[x][y]=cs[i];
                if(x==8&&y==8){
                    cont=false;
                {
                	for(int p=0;p<9;p++){
                		System.out.println();
                		for(int q=0;q<9;q++)
                			System.out.print(board[p][q]);
                	}
                }
                    return;
                }
                if(y<8)
                    solve(board,x,y+1);
                else
                    solve(board,x+1,0);
                if(!cont)
                    return;
                board[x][y]='.';
                rowhs[x][(cs[i]-'1')]=false;
                colhs[y][(cs[i]-'1')]=false;
                blockhs[bidx][(cs[i]-'1')]=false;
            }
        }
        }
    }
    
    public void solveSudoku(char[][] board) {
        iniths(board);    
        solve(board,0,0);
    }
}