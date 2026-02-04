class Solution {
    int[] parent, rank;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = i;
        }

        int numOfComponents = n;

        for(int[] con : connections){
            int a = con[0], b = con[1];
            if(find(a) != find(b)){
                union(a, b);
                numOfComponents--;
            }
        }

        return numOfComponents - 1;


    }

    private void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }

    private int find(int x){
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }
}