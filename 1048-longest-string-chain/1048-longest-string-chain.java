class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];

        Arrays.fill(dp,1);

        Arrays.sort(words, (a,b) -> a.length() - b.length());

        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(checkPossibilities(words[i], words[j]) && 1+dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    private boolean checkPossibilities(String s1, String s2){
        if(s1.length() != s2.length() + 1) return false;
        int first=0,second=0;
        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }
}