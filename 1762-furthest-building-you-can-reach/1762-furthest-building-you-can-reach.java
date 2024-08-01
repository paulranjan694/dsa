class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<heights.length;i++){
            int diff = heights[i] - heights[i-1];
            if(diff>0){
                pq.offer(diff);
                if(pq.size() > ladders){
                    int ele = pq.poll();
                    if(ele <= bricks){
                        bricks-=ele;
                    }else{
                        return i-1;
                    }
                }
            }
        }
        return heights.length-1;
    }
}