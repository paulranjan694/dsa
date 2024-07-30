class KthLargest {
    Queue<Integer> pq=null;
    int kth=0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        kth=k;
        for(int i=0;i<k;i++){
            if(nums.length>i)
                pq.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(!pq.isEmpty() && pq.peek() <= nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(!pq.isEmpty() && pq.peek() <= val && pq.size()==kth){
            pq.poll();
            pq.add(val);
        }
        if(pq.isEmpty() || pq.size() < kth){
            pq.add(val);
        }
        
        return pq.peek() ;

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */