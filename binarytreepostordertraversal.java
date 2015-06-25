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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> st=new Stack<TreeNode>();
        HashMap<TreeNode,Integer> hm=new HashMap<TreeNode,Integer>();
        TreeNode tn=root;
        while(tn!=null){
            while(tn!=null){
                if(hm.get(tn)==null){
                    st.push(tn);
                    hm.put(tn,1);
                    tn=tn.left;
                }
                else if(hm.get(tn)==1){
                    if(tn.right!=null){
                        st.push(tn);
                        hm.put(tn,2);
                        tn=tn.right;
                    }
                    else{
                        hm.put(tn,3);
                        res.add(tn.val);
                    }
                }
                else if(hm.get(tn)==2){
                    hm.put(tn,3);
                    res.add(tn.val);
                }
                else
                    tn=null;
            }
            tn=st.empty()?null:st.pop();
        }
        return res;
    }
}