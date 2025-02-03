class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        int k=3;
        for(int i=0;i<Math.min(k,nums.length);i++){
            if(!visited.contains(nums[i])){
                pq.add(nums[i]);
                visited.add(nums[i]);
            }
        }

        for(int i=k;i<nums.length;i++){
            if(!visited.contains(nums[i])){
                pq.add(nums[i]);
                visited.add(nums[i]);
            }
            if(pq.size() > k){
                pq.poll();
            }
        }


        int ans=0;
        if(pq.size() < k){
            while(pq.size() > 0){
                ans=pq.poll();
            }
            return ans;
        }
        return pq.peek();
    }
}