class Solution {

    //Floyd's algo/ cycle detectation and common node from start and cyclic intersection 
    //tc - O(2n) ~ O(n)
    //sc - O(1)
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);

        fast = nums[0];
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
    //using negative marking 
    //tc - O(2n) ~ O(n)
    //sc - O(1)
    public int findDuplicate2(int[] nums) {
        int n = nums.length,ans=-1;

        for(int i=0;i<n;){
            if(nums[i] > 0){
                nums[i] = -nums[i];
                i = -1 * nums[i];
            }else{
                ans=i;
                break;
            }
        }
        
        for(int i=0;i<n;i++){
            nums[i] = -1 * nums[i];
        }
        return ans;
    }
}