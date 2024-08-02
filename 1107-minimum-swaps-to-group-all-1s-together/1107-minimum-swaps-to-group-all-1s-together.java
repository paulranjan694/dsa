class Solution {
    public int minSwaps(int[] nums) {
                int ones = 0,zeros=0;
        for(int e : nums){
            if(e==1)
                ones++;
            if(e==0)
                zeros++;
        }
        int count=0,cones=Integer.MAX_VALUE;
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i]==1)
                count++;
            if(i - j + 1==ones){
                cones=Math.min(cones,ones-count);
                if(nums[j]==1)
                    count--;
                j++;
            }
        }

        // int czeros=Integer.MAX_VALUE;
        // count=0;
        // for(int i=0,j=0;i<nums.length;i++){
        //     if(nums[i]==0)
        //         count++;
        //     if(i - j + 1==zeros){
        //         czeros=Math.min(czeros,zeros-count);
        //         if(nums[j]==0)
        //             count--;
        //         j++;
        //     }
        // }
      
        //return Math.min(cones,czeros);
        return cones == Integer.MAX_VALUE ? 0 : cones;
    }
}