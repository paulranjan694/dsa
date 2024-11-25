class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int l=0,r=n-1;
        for(int i=0;i<n;i++){
            if(nums[i] > pivot){
                ans[r] = nums[i];
                r--; 
            }else if(nums[i] < pivot){
                ans[l] = nums[i];
                l++;
            }
        }

        for(int i = l; i<=r;i++){
            ans[i] = pivot;
        }

        for(int i = r+1,j=n-1;i<=j;i++,j--){
            int t = ans[i];
            ans[i] = ans[j];
            ans[j] = t;
        }
        return ans;
    }
}