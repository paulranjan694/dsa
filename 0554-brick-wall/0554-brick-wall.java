class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> gapDetails = new HashMap<>();
        
        for(List<Integer> row : wall){
            int gapPos = 0;
            for(int i=0; i < row.size() - 1;i++){
                gapPos += row.get(i);
                if(gapDetails.containsKey(gapPos)){
                    int freq = gapDetails.get(gapPos);
                    gapDetails.put(gapPos,freq + 1);
                }else{
                    gapDetails.put(gapPos,1);
                }
            }
        }

        int maxGaps=0;
        for(int key : gapDetails.keySet()){
            maxGaps = Math.max(maxGaps, gapDetails.get(key));
        }

        return wall.size() - maxGaps;

    }
}