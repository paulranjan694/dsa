class Solution {
    public int longestPalindrome(String[] words) {
        int n=words.length, pair=0,oddPairCount=0;
        Map<String,Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++){
            freq.put(words[i],freq.getOrDefault(words[i], 0)+1);
        }


        for(Map.Entry<String,Integer> entry : freq.entrySet()){
            String key = entry.getKey();
            String rev = new StringBuilder(key).reverse().toString();
            int count = entry.getValue();
            if(freq.containsKey(rev)){
                if(rev.equals(key)){
                    if((count & 1 )== 1){//odd
                        pair += count - 1;
                        oddPairCount = 1;
                    }else{//even
                        pair += count;
                    }
                }else{
                    int count1 = freq.get(key);
                    int count2 = freq.get(rev);
                    int minCount = Math.min(count1,count2);
     
                    freq.put(key,0);
                    freq.put(rev,0);
                    pair += (2*minCount);
                }
            }
        }
        int result= pair*2 + 2*oddPairCount;
      
        return result;
    }
}