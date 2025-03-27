class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int n=time.length;
        int[] map = new int[60];
       
        for(int t : time){
            if(t % 60 == 0){
                count += map[0];
            }else{
                count += map[60-t % 60];
            }
            map[t%60]++;
        }

        return count;
    }
}