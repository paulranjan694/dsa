class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        int n = nums.length;
        for(int num : nums){
            hash.put(num, hash.getOrDefault(num,0)+1);
        }

        List<Integer>[] buckets = new ArrayList[n+1];

        for(Map.Entry<Integer,Integer> entry : hash.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();

            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] res = new int[k];
        int idx=0;
        
        for(int i=n; i>=0 && idx<k;i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    res[idx++] = num;
                    if(idx==k) break;
                }
            }
        }

        return res;
    }
}