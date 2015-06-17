   public int firstMissingPositive(int[] nums) {
        if(nums.length<1) return 1;
        int i=0;
        for(i=0;i<nums.length;i++){
            int num=nums[i]-1;
            if(num>-1&&num<nums.length&&num!=i&&nums[num]!=num+1){
                nums[num]=nums[num]^nums[i];
                nums[i]=nums[num]^nums[i];
                nums[num]=nums[num]^nums[i];
                i--;
            }
        }
        for(i=0;i<nums.length;i++)
            if(nums[i]!=(i+1))
                break;
        return i+1;
    }