public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ll=new ArrayList<List<Integer>>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            for(int j=i+1;j<nums.length-2;j++){
                res=temp-nums[j];
                int begin=j+1;
                int end=nums.length-1;
                int m=begin;
                int n=end;
                while(m<=end&&n>=begin&&m<n){
                    int tsum=nums[m]+nums[n];
                    if(tsum>res)
                        n--;
                    else if(tsum<res)
                        m++;
                    else{
                        List<Integer> li=new ArrayList<Integer>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[m]);
                        li.add(nums[n]);
                        ll.add(li);
                        while(m+1<=end&&nums[m]==nums[m+1]) m++;
                        m++;
                        while(n-1>=begin&&nums[n]==nums[n-1]) n--;
                        n--;
                    }
                }
                while(j+1<nums.length&&nums[j]==nums[j+1])  j++;
            }
            while(i+1<nums.length&&nums[i]==nums[i+1]) i++;
        }
        return ll;
    }
}