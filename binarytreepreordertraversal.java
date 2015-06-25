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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> st=new Stack<TreeNode>();
        HashSet<TreeNode> hs=new HashSet<TreeNode>();
        TreeNode tn=root;
        while(tn!=null){
            while(tn!=null&&!hs.contains(tn)){
                res.add(tn.val);
                st.push(tn);
                hs.add(tn);
                tn=tn.left;
            }
            tn=st.empty()?null:st.pop();
            if(tn!=null&&tn.right!=null){
                tn=tn.right;
            }
        }
        return res;
    }
}