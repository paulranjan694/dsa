class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minheap = new PriorityQueue<>();
        
        List<Double> res = new ArrayList<>();
        Map<Integer,Integer> outgoingnum = new HashMap<>();
        
        for(int i=0;i<k;i++){
          maxheap.offer(nums[i]);
        }

        for(int i=0;i<k/2;i++){
          minheap.offer(maxheap.poll());
        }

        int balance=0;
        for(int i=k;i<nums.length;i++){
            double median = k%2== 0 ? ((long)maxheap.peek()+minheap.peek()) / 2.0 : maxheap.peek();
            res.add(median);

            int outnum = nums[i-k],innum = nums[i];
            
            if(outnum <= maxheap.peek()){
                balance--;
            }else{
                balance++;
            }

            outgoingnum.put(outnum,outgoingnum.getOrDefault(outnum, 0)+1);

            if(maxheap.isEmpty() || maxheap.peek() >=innum){
                balance++;
                maxheap.offer(nums[i]);
            }else{
                minheap.offer(nums[i]);
                balance--;
            }
            

            if(balance < 0){
                maxheap.offer(minheap.poll());
            }else if(balance > 0){
                minheap.offer(maxheap.poll());
            }
            balance=0;

            while(!maxheap.isEmpty() && outgoingnum.containsKey(maxheap.peek()) && outgoingnum.get(maxheap.peek()) > 0){
                outgoingnum.put(maxheap.peek(), outgoingnum.get(maxheap.poll())-1);
            }

            while(!minheap.isEmpty() && outgoingnum.containsKey(minheap.peek()) && outgoingnum.get(minheap.peek()) > 0){
                outgoingnum.put(minheap.peek(), outgoingnum.get(minheap.poll())-1);
            }
          
        }
        double median = k%2== 0 ? ((long)maxheap.peek()+minheap.peek()) / 2.0 : maxheap.peek();
        res.add(median);
        double[] ans = new double[res.size()];
        int idx=0;
        for(double e : res){
          ans[idx++] = e;
        }
        
        return ans;
    }
}