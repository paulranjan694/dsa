class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<heights.length;i++){
            int diff = heights[i] - heights[i-1];
            if(diff>0){
                // pq.offer(diff);
                // if(pq.size() > ladders){
                //     int ele = pq.poll();
                //     if(ele <= bricks){
                //         bricks-=ele;
                //     }else{
                //         return i-1;
                //     }
                // }
                if(pq.size() < ladders){
                    pq.add(diff);
                }else{
                    int br = diff;
                    if(!pq.isEmpty() && pq.peek() < diff){
                        br = pq.poll();
                        pq.add(diff);
                    }

                    if(br<=bricks){
                        bricks-=br;
                    }else{
                        return i-1;
                    }
                }
            }
        }
        return heights.length-1;
    }
}