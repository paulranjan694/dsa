class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int i=0,j=0,mul=1,n=nums.length,count=0;
        while(j<n){
            mul*=nums[j];
            while(i<=j && mul>=k){
                mul/=nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        
        return count;
    }
}