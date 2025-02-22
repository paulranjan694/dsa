class Solution {
    private static final int MODULO = 1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n*(n+1)/2+1];
        int[] pre = new int[n];
        pre[0] = nums[0];
        arr[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = (pre[i-1] + nums[i])% MODULO;
            arr[i] = pre[i] % MODULO;
        }
        int idx=n;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                arr[idx] = (pre[j]-pre[i])% MODULO;
                arr[idx] = arr[idx] % MODULO;
                idx++;
            }
        }

        Arrays.sort(arr);
        int ans=0;
        for(int i=left;i<=right;i++){
            ans += (arr[i] % MODULO);
            ans = ans % MODULO;
        }
        return ans % MODULO;
    }
}