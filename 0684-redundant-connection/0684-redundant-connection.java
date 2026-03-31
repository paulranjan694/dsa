class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;

        DSU dsu = new DSU(n);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(dsu.findParent(u) == dsu.findParent(v)){
                return edge;
            }

            dsu.union(u, v);
        }
        return new int[]{};
    }
}

class DSU{
    int[] rank;
    int[] parent;

    DSU(int n){
        rank = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    public int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public void union(int x, int y){
        int x_parent = findParent(x);
        int y_parent = findParent(y);

        if(x_parent == y_parent) return;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
}

