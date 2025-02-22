class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int m = queries.length, n= nums.length;
        long[] prefixsum = new long[n+1];
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            prefixsum[i+1] = prefixsum[i] + nums[i];
        }
        List<Long> ans = new ArrayList();
        for(int i=0;i<m;i++){
            // int lowerIndex = lowerBound(nums,queries[i]);
            int index = upperBound(nums, queries[i]);
            long left = 1L * queries[i]*index - prefixsum[index];
            long right =prefixsum[n] - prefixsum[index] - ( 1L *(n-index) * queries[i]);
            long res = left+right;
            ans.add(res);
        }
        return ans;
    }

    // private int lowerBound(int[] nums, int t){
    //     int left=0,right=nums.length-1;
    //     int ans=-1;
    //     while(left<=right){
    //         int mid = left + (right - left)/2;
    //         if(nums[mid]>=t){
    //             ans=mid;
    //             right=mid-1;
    //         }else{
    //             left=mid+1;
    //         }
    //     }
    //     return left;
    // }

    private int upperBound(int[] nums, int t){
        int left=0,right=nums.length;
        while(left<right){
            int mid = left + (right - left)/2;
            if(nums[mid]>t){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}