class Solution {
    public String rankTeams(String[] votes) {
        int n = votes.length, l = votes[0].length();
        int[][] map = new int[26][l+1];

        for(char c : votes[0].toCharArray()){
            map[c-'A'][l] = c;
        }

        for(String vote : votes){
            for(int i=0;i<l;i++){
                char c = vote.charAt(i);
               map[c-'A'][i]++;
            }
        }

        List<int[]> list = new ArrayList<>();
        for(int[] arr : map){
            if(arr[l] != 0){
                list.add(arr);
            }
        }

        list.sort((a,b)->{
            for(int i=0;i<l;i++){
                if(a[i]!=b[i]){
                    return b[i]-a[i];
                }
            }
            return a[l]-b[l];
        });

        StringBuilder res = new StringBuilder();
        for(int[] arr : list){
            res.append((char)arr[l]);
        }
        return res.toString();
    }
}