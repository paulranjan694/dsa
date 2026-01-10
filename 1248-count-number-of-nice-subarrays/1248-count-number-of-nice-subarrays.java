class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return findAtMostK(nums, k) - findAtMostK(nums, k-1);
    }

    private int findAtMostK(int[] nums, int k){
        int l=0,r=0,n=nums.length, oddCount=0,numOfSubArr=0;

        while(r<n){
            if(nums[r] % 2 != 0){
                oddCount++;
            }

            while(oddCount > k){
                if(nums[l] % 2 != 0){
                    oddCount--;
                }
                l++;
            }

            numOfSubArr += r-l+1;
            r++;
        }
        return numOfSubArr;
    }
}