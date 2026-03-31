class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int num : nums){
            seen.add(num);
        }

        int len=0;

        for(int num : seen){
            if(!seen.contains(num-1)){
                int t=num,count=0;
                while(seen.contains(t)){
                    count++;
                    t++;
                }
                len = Math.max(len,count);
            }
        }
        return len;
    }
}