public class Solution {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    void permute(int[] idx,boolean[] choose,int[] nums,int cur){
        if(cur==nums.length){
            List<Integer> li=new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++)
                li.add(nums[idx[i]]);
            res.add(li);
            return;
        }
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!choose[i]&&!hs.contains(nums[i])){
                idx[cur]=i;
                choose[i]=true;
                hs.add(nums[i]);
                permute(idx,choose,nums,cur+1);
                choose[i]=false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len=nums.length;
        boolean[] choose=new boolean[len];
        int[] idx=new int[len];
        permute(idx,choose,nums,0);
        return res;
    }
}