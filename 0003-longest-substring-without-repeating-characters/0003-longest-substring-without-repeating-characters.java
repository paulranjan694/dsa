class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> hm = new HashMap<>();

        int l = 0,r = 0,longest = Integer.MIN_VALUE;
        for(r=0;r<n;r++){
            char curr = s.charAt(r);
            while(l<=r && hm.containsKey(curr)){
                char ch = s.charAt(l);
                hm.remove(ch);
                l++;
            }
            hm.put(curr,1);
            longest = Math.max(longest, r-l+1);
        }
        return longest == Integer.MIN_VALUE ? 0 : longest;
    }
}