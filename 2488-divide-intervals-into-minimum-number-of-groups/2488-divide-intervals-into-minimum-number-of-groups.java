class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            if(pq.isEmpty()){
                pq.add(intervals[i][1]);
            }else{
                if(pq.peek() < intervals[i][0]){
                    pq.poll();
                    pq.add(intervals[i][1]);
                }else{
                    pq.add(intervals[i][1]);
                }
            }
        }


        return pq.size();
    }
}