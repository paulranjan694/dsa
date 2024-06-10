class Solution {
    public void sortColors(int[] nums) {
         int n = nums.length;
        for(int i=0,j=0,k=n-1;j<n;j++){
            while((nums[j]==0 || nums[j]==2) && i<=j && j<=k && j<n){
                if(nums[j]==0){
                    int t=nums[i];
                    nums[i] = nums[j];
                    nums[j]=t;
                    i++;
                }
                if(nums[j]==2){
                    int t=nums[k];
                    nums[k]=nums[j];
                    nums[j]=t;
                    k--;
                }
            }
        }
    }
}