class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] visited = new int[100];
        int ans = 0;
        for(List<Integer> list : nums){
            int l = list.get(0);
            int r = list.get(1);
            for(int i = l; i<=r;i++){
                if(visited[i-1]==0){
                    visited[i-1]=1;
                    ans++;
                }
            }
        }
        return ans;
    }
}