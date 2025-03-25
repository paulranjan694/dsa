// class Pair{
//     char ch;
//     int vote;
//     Pair(char c, int v){
//         this.ch =c;
//         this.vote = v;
//     }
// }

class Solution {
    public String rankTeams(String[] votes) {
        Map<Character,int[]> map = new HashMap<>();
        int n = votes.length,votelen = votes[0].length();


        for(int i=0;i<n;i++){
            for(int j=0;j<votelen;j++){
                char ch = votes[i].charAt(j);
                map.putIfAbsent(ch, new int[votelen]);
                map.get(ch)[j]++;
            }
        }
        StringBuilder res = new StringBuilder();
        
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> {
            for(int i = 0; i<votelen;i++){
                if(map.get(a)[i] != map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a-b;
        });

        for(char c : list){
            res.append(c);
        }
        
        return res.toString();
    }
}