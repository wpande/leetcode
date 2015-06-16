public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int begin=0;
        int end=nums.length-1;
        while(begin<=end){
            int mid=(begin+end)/2;
            if(target==nums[mid])
                return mid;
            if(nums[begin]<=nums[end]){
                if(target<nums[mid])
                    end=mid-1;
                else
                    begin=mid+1;
            }
            else{
                if(target<nums[mid]){
                    if(nums[mid]>nums[begin]){
                        if(target<nums[begin]){
                            begin=mid+1;
                        }
                        else if(target==nums[begin]){
                            return begin;
                        }
                        else{
                            begin=begin+1;
                            end=mid-1;
                        }
                    }
                    else if(nums[mid]==nums[begin]){
                        begin=mid+1;
                    }
                    else
                    	end=mid-1;
                }
                else{//target>nums[mid]&nums[begin]>nums[end]
                    if(nums[mid]<nums[end]){
                        if(target<nums[end]){
                            begin=mid+1;
                        }
                        else if(target==nums[end]){
                            return end;
                        }
                        else{
                            end=mid-1;
                        }
                    }
                    else if(nums[mid]==nums[end]){
                        end=mid-1;
                    }
                    else{//nums[mid]>nums[end]
                        begin=mid+1;
                        end=end-1;
                    }
                }
            }
        }
        return -1;
    }
}