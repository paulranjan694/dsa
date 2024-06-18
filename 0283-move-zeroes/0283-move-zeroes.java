class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0,n=nums.length;
        while(j<n){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
            j++;
        }

        while(i<n){
            nums[i]=0;
            i++;
        }

    }
}