public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int sum=-nums[i];
            int begin=i+1;
            int end=nums.length-1;
            int m=begin;
            int n=end;
            while(m<=end&&n>=begin&&m<n){
                if(nums[m]+nums[n]>sum)
                    n--;
                else if(nums[m]+nums[n]<sum)
                    m++;
                else{
                    List<Integer> inner=new ArrayList<Integer>();
                    inner.add(-sum);
                    if(nums[m]>nums[n]){
                        inner.add(nums[n]);
                        inner.add(nums[m]);
                    }
                    else{
                        inner.add(nums[m]);
                        inner.add(nums[n]);
                    }
                    res.add(inner);
                    m++;
                    while(m<=end&&nums[m]==nums[m-1])
                        m++;
                    n--;
                    while(n>=begin&&nums[n]==nums[n+1])
                        n--;
                }
            }
            while(i<nums.length&&nums[i]==-sum){
                i++;
            }
            i--;
        }
        return res;
    }
}