class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for(int i = 0; i < n; i++){
            if(i!=0) temp1[i] = nums[i];
            if(i!=n-1) temp2[i] = nums[i];
        }
        return Math.max(robUtils(temp1, 1),robUtils(temp2,0));
    }

    private int robUtils(int[] arr, int si){
        int n = arr.length;
        //int[] dp = new int[n];
        //Arrays.fill(dp,-1);
        //dp[0] = nums[0];
        int prev1=arr[si],prev2=0,curr=0;
        for(int i=si+1;i<n;i++){
            int take = arr[i];
            if(i>1) take += prev2;
            int notTake =prev1;
            curr = Math.max(take,notTake);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;//n-1
    }
}