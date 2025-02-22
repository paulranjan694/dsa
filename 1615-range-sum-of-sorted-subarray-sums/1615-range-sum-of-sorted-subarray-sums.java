class Solution {
    private static final int MODULO = 1000000007;
    static class Pair{
        int element,index;
        Pair(int element,int index){
            this.element = element;
            this.index = index;
        }

    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        Queue<Pair> minheap = new PriorityQueue<>((Pair a, Pair b) -> a.element - b.element);

        for(int i=0;i<n;i++){
            minheap.add(new Pair(nums[i],i));
        }

        int ans=0;
        for(int i=1;i<=right;i++){
            if(minheap.size() > 0){
                Pair top = minheap.poll();
                if(i>=left){
                    ans += (top.element % MODULO);
                    ans=ans%MODULO;
                }

                if(top.index +1 < n){
                    int newelement = (top.element + nums[top.index +1]) % MODULO;;
                    int newindex = top.index+1;
                    minheap.add(new Pair(newelement,newindex));
                }
            }
        }
        return ans % MODULO;
    }
}