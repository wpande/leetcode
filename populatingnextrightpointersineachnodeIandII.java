/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    static class Ele{
        TreeLinkNode tln;
        int lev;
        Ele(TreeLinkNode ln,int le){
            tln=ln;
            lev=le;
        }
    }
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        Queue<Ele> qu=new LinkedList<Ele>();
        qu.add(new Ele(root,0));
        while(!qu.isEmpty()){
            Ele cur=qu.poll();
            if(cur.tln.left!=null) qu.add(new Ele(cur.tln.left,cur.lev+1));
            if(cur.tln.right!=null) qu.add(new Ele(cur.tln.right,cur.lev+1));
            Ele next=qu.peek();
            if(next!=null&&next.lev==cur.lev)
                cur.tln.next=next.tln;
            else//if(next==null||next.lev>cur.lev)
                cur.tln.next=null;
        }
    }
}