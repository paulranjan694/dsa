class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for(int i=0;i<secret.length();i++){
            map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i), 0)+1);
        }

        int bull=0,cow=0;
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i) == secret.charAt(i)){
                bull++;
                map.put(guess.charAt(i),map.getOrDefault(guess.charAt(i), 0)-1);
            }else{
                list.add(guess.charAt(i));
            }
        }

        for(char c : list){
            if(map.containsKey(c)){
                if(map.get(c) > 0){
                    cow++;
                    map.put(c,map.getOrDefault(c, 0)-1);
                }
            }
        }

        String ans = bull+"A"+cow+"B";
        return ans;
    }
}