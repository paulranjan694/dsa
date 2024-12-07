class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberSubArr(nums,k)-numberSubArr(nums,k-1);
    }

    public int numberSubArr(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length, l = 0, r=0, sum=0,count=0;

        while(r<n){
            sum += (nums[r] % 2);
            while(sum > goal){
                sum -= (nums[l] % 2);
                l++;
            }
            if(sum <= goal){
                count += (r-l+1);
            }
            r++;
        }
        return count;
    }
}