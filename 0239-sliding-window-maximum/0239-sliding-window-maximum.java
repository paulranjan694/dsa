class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        List<Integer> temp = new ArrayList<Integer>();

        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.pollLast();
            }
            dq.add(i);
        }

        temp.add(nums[dq.peekFirst()]);


        for(int i=k;i<n;i++){
            if(i-k == dq.peekFirst()){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.pollLast();
            }
            dq.add(i);
            temp.add(nums[dq.peekFirst()]);
        }
        int[] ans = new int[temp.size()];
        int idx=0;
        for(int e : temp){
            ans[idx++] = e;
        }
        return ans;
    }
}