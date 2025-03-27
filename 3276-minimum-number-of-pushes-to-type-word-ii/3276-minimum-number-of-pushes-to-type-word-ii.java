class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int[] map = new int[26];
        for(char c : word.toCharArray()){
           // System.out.println(c-'a');
            map[c-'a']++;
        }
        Arrays.sort(map);
        int[] sortedMap = new int[26];
         for(int i=0;i<26;i++){
            sortedMap[i] = map[25-i];
         }
        int minpush=0;
        for(int i=0;i<26;i++){
            minpush += (i/8 + 1)*sortedMap[i];
        }
        return minpush;
    }
}