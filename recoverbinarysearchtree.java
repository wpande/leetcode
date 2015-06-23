/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode fn=null;
    TreeNode sn=null;
    TreeNode prior=null;
    void traverseTree(TreeNode root){
        if(root==null)
            return;
        traverseTree(root.left);
        if(prior!=null&&prior.val>root.val){
            if(fn==null){
                fn=prior;
                sn=root;
            }
            else
                sn=root;
        }
        prior=root;
        traverseTree(root.right);
    } 
    public void recoverTree(TreeNode root) {
        traverseTree(root);
        fn.val=fn.val^sn.val;
        sn.val=fn.val^sn.val;
        fn.val=fn.val^sn.val;
    }
}