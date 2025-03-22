class Solution {
    public int longestPalindrome(String[] words) {
        int n=words.length, pair=0,oddPairCount=0;
        Map<String,Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++){
            freq.put(words[i],freq.getOrDefault(words[i], 0)+1);
        }


        for(Map.Entry<String,Integer> entry : freq.entrySet()){
            String key = entry.getKey();
            String rev = "";
            for(int j=1;j>=0;j--){
                rev+=key.charAt(j);
            }
            if(freq.containsKey(rev)){
                if(rev.equals(key)){
                    if((freq.get(key) & 1 )== 1){//odd
                        if(oddPairCount > freq.get(key)){
                           pair += freq.get(key)-1;
                        }else{
                            pair += oddPairCount > 0 ? oddPairCount-1: 0;
                            oddPairCount = freq.get(key);
                        }
                    }else{//even
                        pair += freq.get(key);
                    }
                }else{
                    int f1 = freq.get(key);
                    int f2 = freq.get(rev);
                    int min = 0;
                    if(f1<f2){
                        min = f1;
                        freq.put(key,0);
                        freq.put(rev,f2-f1);
                    }else{
                        min = f2;
                        freq.put(key,f1-f2);
                        freq.put(rev,0);
                    }
                    pair += (2*min);
                }
            }
        }
        int result= pair*2 + 2*oddPairCount;
      
        return result;
    }
}