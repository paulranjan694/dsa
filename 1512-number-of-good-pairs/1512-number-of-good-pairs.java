class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] hash = new int[101];

        for(int e : nums){
            hash[e]++;
        }

        int count=0;
        for(int f : hash){
            count += (f * (f-1))/2;
        }
        return count;
    }
}