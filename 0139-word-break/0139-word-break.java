class Solution {
    Boolean[] memo;
    Set<String> dict;
    int n, maxLen = 0;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dict = new HashSet<>(wordDict);
        memo = new Boolean[n];

        for(String w : wordDict){
            maxLen = Math.max(maxLen, w.length());
        }

        return solve(s, 0);
    }

    private boolean solve(String s, int idx){
        if(idx == n) return true;
        if(memo[idx] != null) return memo[idx];

        for(int l = idx + 1; l <= n && l - idx <= maxLen; l++){
            if(dict.contains(s.substring(idx, l)) && solve(s, l)){
                return memo[idx] = true;
            }
        }
        return memo[idx] = false;
    }
}
