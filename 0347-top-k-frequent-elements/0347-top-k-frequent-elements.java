class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();

        for(int num : nums){
            hash.put(num, hash.getOrDefault(num,0)+1);
        }

        PriorityQueue<Pair<Integer,Integer>> heap = new PriorityQueue<>((Pair<Integer,Integer> a, Pair<Integer,Integer> b) -> Integer.compare((int)a.getValue(),(int)b.getValue()));

        for(Map.Entry<Integer,Integer> entry : hash.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            Pair<Integer,Integer> p = new Pair<Integer,Integer>(key,value);

            heap.add(p);

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        int idx=0;
        while(!heap.isEmpty()){
            Pair<Integer,Integer> pair = heap.poll();
            res[idx++] = pair.getKey();
        }
        return res;
    }
}