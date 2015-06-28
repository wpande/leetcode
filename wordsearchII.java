public class Solution {
    class TrieNode {
    // Initialize your data structure here.
    boolean[] letters;
    boolean[] end;
    TrieNode[] nodes;
    public TrieNode() {
        letters=new boolean[26];
        end=new boolean[26];
        nodes=new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int len=word.length();
        TrieNode p=root;
        TrieNode prn=p;
        int pridx=0;
        for(int i=0;i<len;i++){
            int idx=(int)(word.charAt(i)-'a');
            if(p!=null){
                if(!p.letters[idx]){
                    p.letters[idx]=true;
                }
                if(i==len-1)
                    p.end[idx]=true;
                pridx=idx;
                prn=p;
                p=p.nodes[idx];
            }
            else{
                prn.nodes[pridx]=new TrieNode();
                p=prn.nodes[pridx];
                p.letters[idx]=true;
                if(i==len-1)
                    p.end[idx]=true;
                pridx=idx;
                prn=p;
                p=p.nodes[idx];
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int len=word.length();
        TrieNode p=root;
        for(int i=0;i<len;i++){
            int idx=(int)(word.charAt(i)-'a');
            if(p==null)
                return false;
            if(!p.letters[idx])
                return false;
            if(i==len-1&&!p.end[idx])
                return false;
            p=p.nodes[idx];
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int len=prefix.length();
        TrieNode p=root;
        for(int i=0;i<len;i++){
            int idx=(int)(prefix.charAt(i)-'a');
            if(p==null)
                return false;
            if(!p.letters[idx])
                return false;
            p=p.nodes[idx];
        }
        return true;
    }
}
    
    void recfind(char[][] board, Trie tr, Set<String> res, int curx, int cury, String str){
        int lenx=board.length;
        int leny=board[0].length;
        if(curx==lenx||curx<0||cury<0||cury==leny||board[curx][cury]=='0')
            return;
        str=str+board[curx][cury];
        if(tr.search(str))
            res.add(str);
        if(!tr.startsWith(str))
            return;
        char ch=board[curx][cury];
        board[curx][cury]='0';
        recfind(board,tr,res,curx-1,cury,str);
        recfind(board,tr,res,curx+1,cury,str);
        recfind(board,tr,res,curx,cury-1,str);
        recfind(board,tr,res,curx,cury+1,str);
        board[curx][cury]=ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie tr=new Trie();
        int len=words.length;
        for(int i=0;i<len;i++)
            tr.insert(words[i]);
        int lenx=board.length;
        int leny=board[0].length;        
        Set<String> res=new HashSet<String>();
        for(int i=0;i<lenx;i++)
            for(int j=0;j<leny;j++)
                recfind(board, tr, res, i, j, "");
        return new ArrayList(res);
    }
}