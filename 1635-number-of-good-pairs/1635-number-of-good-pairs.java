class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }

        int ans=0;
        for(Integer k: map.keySet()){
            if(map.get(k)>1){
                int val=map.get(k);
                ans += ((val*(val-1))/2);
            }
        }
        return ans;
    }
}