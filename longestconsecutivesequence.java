public class Solution {
    class Interval{
        int left;
        int right;
        Interval(int l,int r){
            left=l;
            right=r;
        }
    }
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Interval> hm=new HashMap<Integer, Interval>();
        int len=nums.length;
        if(len<1)
            return 0;
        int res=1;
        for(int i=0;i<len;i++)
            if(!hm.containsKey(nums[i])){
                int left=nums[i];
                int right=left;
                if(nums[i]!=Integer.MIN_VALUE&&hm.containsKey(nums[i]-1))
                    left=hm.get(nums[i]-1).left;
                if(nums[i]!=Integer.MAX_VALUE&&hm.containsKey(nums[i]+1))
                    right=hm.get(nums[i]+1).right;
                hm.put(nums[i],new Interval(left,right));
                if(right-left+1>res)
                    res=right-left+1;
                Interval buf=hm.get(left);
                buf.left=left;
                buf.right=right;
                buf=hm.get(right);
                buf.left=left;
                buf.right=right;
            }
        return res;
    }
}