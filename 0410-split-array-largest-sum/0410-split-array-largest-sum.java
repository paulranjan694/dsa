class Solution {
    public int splitArray(int[] nums, int k) {
        int max=Integer.MIN_VALUE,sum=0,n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            sum+=nums[i];
        }

        int low = max,high=sum;
        while(low<=high){
            int mid = low + (high-low)/2;
            int partitions = ispossible(nums,mid);
            if(partitions > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    private int ispossible(int[] nums,int maxsum){
        int partitions=1,partitionsum=0;
        for(int i =0;i<nums.length;i++){
            if(partitionsum+nums[i] <= maxsum){
                partitionsum += nums[i];
            }else{
                partitions++;
                partitionsum = nums[i];
            }
        }

        return partitions;
    }
}