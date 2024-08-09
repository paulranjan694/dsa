class Solution {
    public int lengthOfLongestSubstring(String s) {
        //if(s.length()==1) return 1;
        Map<Character,Integer> map = new HashMap<>();
        int max=-1;
        int i=0,j=0;
        for(;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                max=Math.max(max,i-j);
                while(j<=i && map.containsKey(ch) && map.get(ch) >= 1){
                    map.remove(s.charAt(j));
                    j++;
                }
                 map.put(ch,map.getOrDefault(ch, 0)+1);
                if(j>i)
                    return max;
            }else{
                map.put(ch,1);
            }
        }

        
        max=Math.max(max,i-j);


        return max;
    }
}