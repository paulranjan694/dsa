class Solution {
    private static final int modulo = 1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> subArrSum = new ArrayList<>();

        for(int i=0;i<n;i++){
            int sum = (nums[i] % modulo);
            for(int j=i+1;j<n;j++){
                sum+=(nums[j]% modulo);
                sum=sum % modulo;
                subArrSum.add(sum % modulo);
            }
        }

        for(int i=0;i<n;i++){
            subArrSum.add(nums[i] % modulo);
        }

        Collections.sort(subArrSum);

        int ans=0;
        for(int i=left-1;i<=right-1;i++){
            ans += (subArrSum.get(i) % modulo);
            ans = ans % modulo;
        }
        return ans % modulo;
    }
}