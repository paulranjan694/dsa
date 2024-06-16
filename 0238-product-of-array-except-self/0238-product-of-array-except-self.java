class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] r = new int[n];

        r[0]=1;
        for(int i=1;i<n;i++){
            r[i]=r[i-1]*nums[i-1];
        }

        int prod=1;
        for(int i=n-2;i>=0;i--){
            prod*=nums[i+1];
            r[i]=r[i]*prod;
        }

        return r;
    }
}