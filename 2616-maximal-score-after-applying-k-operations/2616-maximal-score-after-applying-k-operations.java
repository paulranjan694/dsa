class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        long score = 0;

        for(int e : nums){
            maxHeap.add(e);
        }

        while(k-- > 0){
            int num = maxHeap.poll();
            score += num;
            num = (int)Math.ceil(num/3.0);
            maxHeap.add(num);
        }

        return score;

    }
}