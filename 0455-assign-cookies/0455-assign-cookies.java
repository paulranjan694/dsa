class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0,ans=0;
        for(int i=0;i<g.length;i++){
            if(s[j]>=g[i]){
                ans++;j++;
            }
        }
        return ans;
    }
}