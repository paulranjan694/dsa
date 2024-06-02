class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for(int i=0,k=0,j=n-1;k<n;){
            while(i <= k && k <= j && k < n && (nums[k] == 0 || nums[k]==2)){
                if(nums[k] == 0){
                    int t = nums[i];
                    nums[i] = nums[k];
                    nums[k]=t;
                    i++;
                }
                
                if(nums[k] == 2){
                    int t = nums[j];
                    nums[j] = nums[k];
                    nums[k]=t;
                    j--;
                }
            }
            k++;
        }
    }
}