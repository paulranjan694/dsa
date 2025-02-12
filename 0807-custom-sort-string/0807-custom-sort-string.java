class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new TreeMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        // for(int i=0;i<order.length();i++){
        //     char c = order.charAt(i);
        //     if(!map.containsKey(c)){
        //       break;
        //     }
        //     map.put(c,map.getOrDefault(c,0)-1);
        //     sb.append(c);
        // }

        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            if(!map.containsKey(c)){
              break;
            }
           for(int j=0;j<map.get(c);j++){
              sb.append(c);
            }
            map.remove(c);
        }
        
        for(char key : map.keySet()){
            for(int i=0;i<map.get(key);i++){
              sb.append(key);
            }
        }
        return sb.toString();
    }
}