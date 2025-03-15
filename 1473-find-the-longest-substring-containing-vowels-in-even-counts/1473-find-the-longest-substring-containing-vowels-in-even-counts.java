class Solution {
    public int findTheLongestSubstring(String s) {
        int length=s.length(), maxlen=0;
        Map<Character,Integer> indexes = new HashMap<>();
        Map<String,Integer> frequencies = new HashMap<>();
        indexes.put('a',0);
        indexes.put('e',1);
        indexes.put('i',2);
        indexes.put('o',3);
        indexes.put('u',4);
        
        int[] bitmask = new int[5];
        frequencies.put("00000",-1);

        for(int i=0;i<length;i++){
            int index = indexes.getOrDefault(s.charAt(i), -1);
            if(index>=0){
                bitmask[index] = (bitmask[index] + 1) % 2;
            }

            StringBuilder bitMasking = new StringBuilder();
            for(int j=0;j<5;j++){
                bitMasking.append(bitmask[j]);
            }

            String bit = bitMasking.toString();

            if(frequencies.containsKey(bit)){
                maxlen=Math.max(maxlen,i-frequencies.get(bit));
            }else{
                frequencies.put(bit,i);
            }
        }
        
        return maxlen;
    }
}