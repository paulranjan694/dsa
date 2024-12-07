class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length, l = 0, r=0, sum=0,count=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(r<n){
            sum += nums[r];
            if(sum == goal){
               count++;
            }

            if(hm.containsKey(sum-goal)){
                count += hm.get(sum-goal);
            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
            
            r++;
        }
        return count;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        return (numberSubArr(nums,goal) - numberSubArr(nums, goal-1));
    }

    public int numberSubArr(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length, l = 0, r=0, sum=0,count=0;

        while(r<n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            if(sum <= goal){
                count += (r-l+1);
            }
            r++;
        }
        return count;
    }
}