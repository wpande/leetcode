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
    int res=Integer.MIN_VALUE;
    void maxPath(TreeNode root){
        if(root==null)
            return;
        maxPath(root.left);
        maxPath(root.right);
        int temp=0;
        if(root.left!=null&&root.right==null){
            root.val+=root.left.val>0?root.left.val:0;
            res=Math.max(res,root.val);
        }
        else if(root.left==null&&root.right!=null){
            root.val+=root.right.val>0?root.right.val:0;
            res=Math.max(res,root.val);
        }
        else if(root.left!=null&&root.right!=null){
            temp=root.val;
            temp+=root.left.val>0?root.left.val:0;
            res=Math.max(res,temp);
            temp=root.val;
            temp+=root.right.val>0?root.right.val:0;
            res=Math.max(res,temp);
            temp=root.val+root.right.val+root.left.val;
            res=Math.max(res,temp);
            temp=Math.max(root.left.val,root.right.val);
            root.val+=temp>0?temp:0;
        }
        else
            res=Math.max(res,root.val);
    }
    
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return res;
    }
}