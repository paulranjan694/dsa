class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int f = map.getOrDefault(nums[i],0);
            map.put(nums[i],f+1);
        }

        Queue<Integer> pq = new PriorityQueue<Integer>((n1,n2) -> map.get(n1) - map.get(n2));
        for(int key:map.keySet()){
            pq.add(key);
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }

        return ans;
    }
}