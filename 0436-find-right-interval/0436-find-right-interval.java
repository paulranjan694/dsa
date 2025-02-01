class Solution {
    public int[] findRightInterval(int[][] intervals) {
        Queue<int[]> start = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Queue<int[]> end = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] res = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            int[] startarr = new int[2];
            int[] endarr = new int[2];
            
            startarr[0] = intervals[i][0];
            endarr[0] = intervals[i][1];
            
            startarr[1] = i;
            endarr[1] = i;
            start.offer(startarr);
            end.offer(endarr);
        }
        
        while(!start.isEmpty() && !end.isEmpty()){
          while(!start.isEmpty() && start.peek()[0] < end.peek()[0]){
            start.poll();
          }
          
          if(!start.isEmpty())
            res[end.poll()[1]]=start.peek()[1];
          
        }

        while(!end.isEmpty()){
            res[end.poll()[1]]=-1;
        }

        return res;
    }
}