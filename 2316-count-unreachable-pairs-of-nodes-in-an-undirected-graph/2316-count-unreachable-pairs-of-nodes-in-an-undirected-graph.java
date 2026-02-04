class Solution {
    int[] rank,parent;
    public long countPairs(int n, int[][] edges) {
        rank = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=i;
        }

        for(int[] edge : edges){
            int a = edge[0],b=edge[1];
            if(find(a) != find(b)){
                union(a,b);
            }
        }

        Map<Integer,Long> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int parent = find(i);
            map.put(parent, map.getOrDefault(parent, 0L)+1L);
        }

        int remaining = n;
        long result=0;

        for(long size : map.values()){
            result += size * (remaining - size);
            remaining -= size;
        }

        return result;
    }

    private void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else{
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }

    private int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}