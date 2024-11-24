class Solution {

    //tc - O(n)
    //sc - O(1)
    public int firstMissingPositive(int[] nums) {
        int n= nums.length;

        for(int i =0;i<n;i++){
            if(nums[i] <= 0) nums[i] = n+2;
        }

        for(int i = 0 ; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(idx >= 0 && idx < n){
                nums[idx] = Math.abs(nums[idx]) * -1;
            }
        }

        for(int i = 1; i <= n; i++){
            if(nums[i-1] > 0){
                return i;
            }
        }
        return n+1;
       
    }

    //tc - O(n)
    //sc - O(n)
    public int firstMissingPositive2(int[] nums) {
        int max = 0, n= nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            set.add(nums[i]);
        }

        for(int i = 1; i <= max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}