class Solution {
    int[] parent= new int[26];
    int[] rank = new int[26];
    public boolean equationsPossible(String[] equations) {
        for(int i = 0; i<26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        List<String> processLater = new ArrayList<>();
        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                processLater.add(eq);
            }else{
                char a = eq.charAt(0), b = eq.charAt(3);
                union(a-'a', b-'a');
            }
        }

        for(String eq : processLater){
            char a = eq.charAt(0), b = eq.charAt(3);
            if(find(a-'a') == find(b-'a')){
                return false;
            }
        }
        return true;
    }

    private void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else {
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }

    private int find(int x){
        if(x==parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}