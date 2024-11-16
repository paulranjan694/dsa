class Solution {
    //tc - O(n)
    //sc - O(1)
    //Moore’s Voting Algorithm
    public int majorityElement(int[] nums) {
        int ele = nums[0], cnt = 1, n= nums.length;

        for(int i=1;i<n;i++){
            if(cnt==0){
                ele=nums[i];
                cnt=1;
            }
            else if(ele==nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        return ele;
    }
}