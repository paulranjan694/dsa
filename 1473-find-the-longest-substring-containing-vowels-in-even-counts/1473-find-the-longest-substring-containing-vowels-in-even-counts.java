class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer,Integer> bitmaskFreqMap = new HashMap<>();

        Map<Character,Integer> indexes = new HashMap<>();
        indexes.put('a',0);
        indexes.put('e',1);
        indexes.put('i',2);
        indexes.put('o',3);
        indexes.put('u',4);

        int mask=0,maxlen=0;
        
        bitmaskFreqMap.put(mask,-1);

        for(int i=0;i<s.length();i++){
            int bit = indexes.getOrDefault(s.charAt(i), -1);
            if(bit >=0){
                mask = mask ^ (1<<bit);
            }

            if(bitmaskFreqMap.containsKey(mask)){
                maxlen = Math.max(maxlen,i-bitmaskFreqMap.get(mask));
            }else{
                bitmaskFreqMap.put(mask,i);
            }
        }
        return maxlen;
    }
}