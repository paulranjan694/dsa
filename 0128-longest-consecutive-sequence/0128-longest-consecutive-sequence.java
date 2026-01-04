class Solution {
    public int longestConsecutive(int[] nums) {
        int maxSeq = 0;
        Set<Integer> seen = new HashSet<Integer>();
        for(int num : nums){
            seen.add(num);
        }

   
        for(int num : seen){
            if(!seen.contains(num-1)){
                int currentStreak = 0;
                int currNum = num;
                while(seen.contains(currNum)){
                    currentStreak += 1;
                    currNum += 1;
                }
                maxSeq = Math.max(currentStreak,maxSeq);
            }
        }
        return maxSeq;
    }
}