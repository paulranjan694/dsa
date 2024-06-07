class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return true;
        Map<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int freq = hm.getOrDefault(ch,0);
            hm.put(ch,freq+1);
        }

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            int freq = hm.getOrDefault(ch,0);
            if(freq>0)
                hm.put(ch,freq-1);
        }

        for(Character key: hm.keySet()){
            if(hm.get(key) >0)
                return false;
        }

        return true;
    }
}