class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, i=0,j=n-1,p=1,s=1,max=Integer.MIN_VALUE;
        while(i<n){
            p = p * nums[i];
            s = s * nums[n-i-1];
            max = Math.max(max,Math.max(p,s));
            if(p==0) p=1;
            if(s==0) s=1;
            i++;
        }
        return max;
    }
}