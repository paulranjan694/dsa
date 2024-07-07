class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }

        int[] ans = new int[k];
        List<Integer> freq[] = new ArrayList[nums.length+1];

        for(Integer key : map.keySet()){
            int f = map.get(key);
            if(freq[f]==null)
                freq[f] = new ArrayList<>();
            freq[f].add(key);
        }

        int index=0;
        for(int i = nums.length;i>=0;i--){
            if(freq[i]!=null){
                for(Integer e : freq[i]){
                    ans[index++]=e;
                    if(index==k)
                        return ans;
                }
            }
        }
        return ans;
    }
}