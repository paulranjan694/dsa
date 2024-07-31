class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int e: tasks){
            map.put(e, map.getOrDefault(e,0)+1);
        }
                
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[][]> queue = new LinkedList<>();

        for(int e : map.values()){
            pq.add(e);
        }

        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            if(!pq.isEmpty()){
                int ele = pq.poll();
                if(ele - 1 > 0){
                    int[][] ar = new int[1][2];
                    ar[0][0] = ele - 1;
                    ar[0][1] = time + n;
                    queue.offer(ar);
                }
            }

            if(!queue.isEmpty() && queue.peek()[0][1] == time){
                int[][] arr = queue.poll();
                pq.add(arr[0][0]);
            }
            time++;
        }
        return time;


    }
}