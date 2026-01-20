class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            // j | (j+1) is always odd
            if ((x & 1) == 0) {
                ans[i] = -1;
            } else {
                int lowestZeroBit = (~x) & (x + 1); // gives 2^p
                ans[i] = x - (lowestZeroBit >> 1);
            }
        }

        return ans;
    }
}