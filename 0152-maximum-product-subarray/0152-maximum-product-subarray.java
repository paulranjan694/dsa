class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE,prefix=1,suffix=1,n=nums.length;
        for(int i=0;i<n;i++){
            prefix = prefix*nums[i];
            suffix = suffix*nums[n-i-1];
            max = Math.max(max,Math.max(prefix,suffix));
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
        }
        return max;
    }
}