class Solution {
    public int numIdenticalPairs(int[] nums) {
       //Map<Integer,Integer> map = new HashMap<>();
        int[] freq = new int[101];
        for(int e : nums){
           freq[e]++;
        }

        int ans=0;
        // for(Integer k: map.keySet()){
        //     if(map.get(k)>1){
        //         int val=map.get(k);
        //         ans += ((val*(val-1))/2);
        //     }
        // }
        for(int e : freq){
            if(e >1){
                ans += ((e*(e-1))/2);
            }
        }
        return ans;
    }
}