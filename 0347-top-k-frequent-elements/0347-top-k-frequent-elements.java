class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int num : nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

       Queue<int[]> minHeap = new PriorityQueue<>((int[] a, int[] b) -> a[1]-b[1]);

        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            int[] pair = new int[]{entry.getKey(),entry.getValue()};
            minHeap.add(pair);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] finalResult = new int[k];
        for(int i=0;i<k;i++){
            int[] pair = minHeap.poll();
            finalResult[i] = pair[0];
        }
        return finalResult;
    }
}