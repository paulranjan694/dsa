
class Solution {
    private boolean comparePossible(String s1, String s2){
        if(s1.length() != s2.length() + 1) return false;
        int first = 0,second=0;
        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }

        if(first == s1.length() && second == s2.length()) return true;
        return false;

    }
    public int longestStrChain(String[] words) {
        int n = words.length,max=1;

        Arrays.sort(words,(String s1,String s2) -> Integer.compare(s1.length(), s2.length()));
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i =1;i<n;i++){
            for(int j=0;j<i;j++){
                if(comparePossible(words[i], words[j]) && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}