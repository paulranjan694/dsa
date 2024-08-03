class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0,ans=0,i=0;
        while(i<s.length && j<g.length){
            if(s[i]>=g[j]){
                ans++;j++;
            }
            i++;
        }
        return ans;
    }
}