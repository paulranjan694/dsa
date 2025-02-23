class Solution {
    static class SortComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return Integer.compare(b, a);
        }
    }
    public int smallestDistancePair(int[] nums, int k) {
        //Queue<Integer> maxheap = new PriorityQueue<>(new SortComparator());
        //Set<Integer> alreadyExists = new HashSet<>();
        int[] buckets = new int[1000001];
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs(nums[i]-nums[j]);
                buckets[dist]++;
                // maxheap.add(dist);
                // if(maxheap.size() > k){
                //     maxheap.poll();
                // }
                // if(!alreadyExists.contains(dist)){
                // }
                //alreadyExists.add(dist);
            }
        }
        int ans=-1;
        for(int i=0;i<1000001;i++){
            if(buckets[i] > 0){
                k-=buckets[i];
            }
            if(k<=0){
                ans=i;
                break;
            }
        }
        return ans;
        // while(k-->0 && maxheap.size() > 0){
        //     ans=maxheap.poll();
        // }
        //return maxheap.peek();
    }
}