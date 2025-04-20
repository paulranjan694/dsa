class Solution {
    public int numRabbits(int[] answers) {
        int[] hash = new int[1001];

        for(int ans : answers){
            hash[ans]++;
        }

        int min = 0;
        for(int i=0;i<1001;i++){
            if(hash[i] > 0){
                int group = (int)Math.ceil((double)hash[i]/(i+1));
                min += ( group * (i+1));
            }
        }
        return min;
    }
}