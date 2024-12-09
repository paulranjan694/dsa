class SortComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair a, Pair b){
        return Integer.compare(b.dist,a.dist);
    }
}

class Pair{
    int x, y, dist;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
        this.dist = (x*x) + (y*y);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>(new SortComparator());
        int n = points.length;
        for(int i=0;i<n;i++){
            Pair p = new Pair(points[i][0],points[i][1]);
            pq.add(p);
            while(!pq.isEmpty() && pq.size()> k ){
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int idx=k-1;
        while(k-- > 0){
            Pair p1 = pq.poll();
            ans[idx][0] = p1.x;
            ans[idx][1] = p1.y;
            idx--;
        }
        return ans;
    }
}