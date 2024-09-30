class Solution {

    //using binary search, just to find the length of LIS, we are not storing the LIS.
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);

        for(int i = 1; i < n; i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int idx = lowerBound(nums[i],list,0, list.size()-1);
                list.set(idx,nums[i]);
            }
        }
        return list.size();
    }

    private int lowerBound(int ele, ArrayList<Integer> list, int s, int e){
        while(s<e){
            int mid = (s+e) / 2;
            if(list.get(mid)== ele){
                return mid;
            }
            if(list.get(mid)> ele){
                e = mid;
            }else{
                s = mid+1;
            }
        }
        return s;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return utils(nums, 0,-1,dp);
    }

    private int utils(int[] nums, int idx, int prevIdx, int[][] dp){
        //base case
        if(idx >= nums.length) return 0;
        if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[idx])
            take = 1 + utils(nums, idx+1, idx,dp);
        int notTake = utils(nums,idx+1,prevIdx,dp);
        return dp[idx][prevIdx+1] =  Math.max(take,notTake);
    }
}         