class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i=n-2;
        boolean found=false;
        while(i>=0){
            if(nums[i] < nums[i+1]){
                int j=n-1;
                while(j >= 0 && nums[j] <= nums[i]){
                    j--;
                }
                swap(nums,i,j);
                reverse(nums,i+1);
                found=true;
                break;
            }
            i--;
        }

        if(found==false){
            reverse(nums,0);
        }
    }

    private void reverse(int[] nums, int s){
        int e = nums.length-1;
        while(s<=e){
            swap(nums,s,e);
            s++;e--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}