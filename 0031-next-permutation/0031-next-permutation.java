class Solution {
    public void nextPermutation(int[] nums) {
        int n =nums.length;
        int i=n-1,j=n-2;

        while(j>=0 && nums[j] >= nums[j+1]){
            j--;
        }

        if(j==-1){
            for(i=0,j=n-1;i<=j;i++,j--){
                int t = nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
        }else{
            while(i>=0 && nums[i] <= nums[j]){
                i--;
            }
            int t = nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            for(i=j+1,j=n-1;i<=j;i++,j--){
                t = nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }

        }
    }
}