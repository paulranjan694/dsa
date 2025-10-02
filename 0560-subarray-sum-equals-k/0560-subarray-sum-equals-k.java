class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,1);
            
        int sum=0, numOfWays=0;

        for(int e: nums){
            sum += e;
            numOfWays += hash.getOrDefault(sum-k, 0);

            hash.put(sum, hash.getOrDefault(sum, 0)+1);
        }

        return numOfWays;


    }
}