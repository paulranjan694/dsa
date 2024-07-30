class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<Integer>((n1,n2) -> n2-n1);

        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(!pq.isEmpty() && pq.size()>1){
            int x = pq.poll();

            int y = -1;
            if(!pq.isEmpty())
                y=pq.poll();
            
            if(y==-1)
                break;
            if(x>y){
                pq.add(x-y);
            }else if(y>x){
                pq.add(y-x);
            }
        }

        if(pq.isEmpty())
            return 0;
        return pq.peek();
    }
}