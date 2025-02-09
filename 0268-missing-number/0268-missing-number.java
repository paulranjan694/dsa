class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int index=0,val=0;
        while(index<n){
            val = nums[index];
            if(val < n && index != val){
                int t = nums[index];
                nums[index] = nums[val];
                nums[val] = t;
            }else if(val>=n){
                index++;
            }else{
                index++;
            }
        }

        for(int i=0;i<n;i++){
            if(i != nums[i]){
                return i;
            }
        }
        return n;
    }
}