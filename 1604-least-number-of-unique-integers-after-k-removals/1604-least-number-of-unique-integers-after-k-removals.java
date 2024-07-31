class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int f = map.getOrDefault(arr[i],0);
            map.put(arr[i],f+1);
        }

        Queue<Integer> pq = new PriorityQueue<>(map.values());

        while(k > 0 && !pq.isEmpty()){
            int ele = pq.poll();
            if(ele < k)
                k-=ele;
            else{
                if(ele==k){
                    break;
                }else{
                    pq.add(ele-k);
                    break;
                }
            }
        }

        return pq.size();
    }
}