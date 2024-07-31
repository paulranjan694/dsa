class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int f = map.getOrDefault(arr[i],0);
            map.put(arr[i],f+1);
        }

        Queue<Integer> pq = new PriorityQueue<>((n1,n2)->map.get(n1) - map.get(n2));
        for(int key:map.keySet()){
            pq.add(key);
        }

        while(k-- > 0){
            int key = pq.poll();
            int f = map.get(key);
            if(f>1){
                map.put(key, f-1);
                pq.add(key);
            }else{
                map.remove(key);
            }
        }

        return map.size();
    }
}