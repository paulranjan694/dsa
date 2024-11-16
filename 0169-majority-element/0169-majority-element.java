class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0], cnt = 1, n= nums.length;

        for(int i=1;i<n;i++){
            if(cnt==0){
                ele=nums[i];
                cnt=1;
                continue;
            }
            if(ele==nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        return ele;
    }
}