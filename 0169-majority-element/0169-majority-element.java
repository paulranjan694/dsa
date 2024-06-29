class Solution {
    public int majorityElement(int[] nums) {
        int currEle = nums[0], count=1,n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==currEle){
                count++;
            }else{
                count--;
            }
            if(count<=0){
                currEle=nums[i];
                count=1;
            }
        }

        count=0;
         for(int i=0;i<n;i++){
            if(nums[i]==currEle){
                count++;
            }
        }

        if(count>(n/2))
            return currEle;
        return -1;

    }
}