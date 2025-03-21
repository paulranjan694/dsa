class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        Set<Character> set = new LinkedHashSet<>();
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            //set.add(s.charAt(i));
        }

        for(int i=0;i<s.length();i++){
           if(freq[s.charAt(i)-'a']==1) return i;
            //set.add(s.charAt(i));
        }

        // for(char c : set){
        //     if(freq[c-'a']==1) return s.indexOf(c);
        // }
        return -1;
    }
}