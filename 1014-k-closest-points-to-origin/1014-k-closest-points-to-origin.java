class Distance{
    int x;
    int y;
    int distance;
    public Distance(int x,int y){
        this.x=x;
        this.y=y;
        this.distance = (x*x)+(y*y);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Distance> pq = new PriorityQueue<>((Distance d1, Distance d2) -> d2.distance - d1.distance);
        for(int i=0;i<k;i++){
            pq.add(new Distance(points[i][0], points[i][1]));
        }

        for(int i=k;i<points.length;i++){
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            if(dist < pq.peek().distance){
                pq.poll();
                pq.add(new Distance(points[i][0], points[i][1]));
            }
        }

        int[][] ans = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            Distance d = pq.poll();
            ans[i][0] = d.x;
            ans[i][1] = d.y;
            i++;
        }
        return ans;
    }
}