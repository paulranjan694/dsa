class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> temp = new ArrayList<>();

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]){
                dq.pollLast();
            }

            dq.addLast(i);
        }

        temp.add(nums[dq.getFirst()]);

        for(int i=k;i<n;i++){
            if(!dq.isEmpty() && dq.getFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]){
                dq.pollLast();
            }

            dq.addLast(i);
            temp.add(nums[dq.getFirst()]);
        }

        int[] res = new int[temp.size()];

        for(int i=0;i<res.length;i++){
            res[i] = temp.get(i);
        }

        return res;


    }
}