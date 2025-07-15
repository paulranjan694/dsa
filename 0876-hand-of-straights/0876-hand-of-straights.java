class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) return false;

        Map<Integer,Integer> hash = new HashMap<>();

        for(int i=0;i<n;i++){
            hash.put(hand[i],hash.getOrDefault(hand[i],0)+1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);

        for(Integer k : hash.keySet()){
            minHeap.add(k);
        }

        while(minHeap.size() > 0){
            int k = 0;
            int minVal = minHeap.peek();
            while(k<groupSize){
                int newKey = minVal+k;
                if(hash.containsKey(newKey)){
                    hash.put(newKey,hash.getOrDefault(newKey,0)-1);
                    if(hash.get(newKey) <= 0){
                        if(minHeap.size() > 0 && minHeap.peek() != newKey){
                            return false;
                        }
                        minHeap.poll();
                    }
                }else{
                    return false;
                }
                k++;
            }
        }

        return true;
    }
}