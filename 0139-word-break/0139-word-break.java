class Solution {
    Boolean[] memo;
    Set<String> dict;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dict = new HashSet<>(wordDict);
        memo = new Boolean[n];
        return solve(s,0);
    }

    private boolean solve(String s, int idx){
        if(idx>=n) return true;
        if(memo[idx] != null) return memo[idx];
        for(int l=idx+1;l<=n;l++){
            String temp = s.substring(idx,l);
            if(dict.contains(temp) && solve(s,l)){
                return memo[idx] = true;
            }
        }
        return memo[idx]=false;
    }
}