class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;

        int longestSubstringLength = 0;
        Set<Character> set=new HashSet<>();
        int i=0,j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(set.contains(ch)){
                while(i<=j && set.contains(ch)){
                    longestSubstringLength = Math.max(longestSubstringLength, j-i);
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(ch);
            }else{
                set.add(ch);
            }
            j++;
        }
        longestSubstringLength = Math.max(longestSubstringLength, j-i);
        return longestSubstringLength;
    }
}