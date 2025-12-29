class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length, i=0,j=0, count=0;
        while(i< n && j < m){
            if(g[i]<=s[j]){
                i++;j++;count++;
            }else{
                j++;
            }
        }
        return count;
    }
}