class Solution {
    List<Integer> prefixSum = new ArrayList<>();
    int totalSum=0;
    public Solution(int[] w) {
        int tempSum=0,n=w.length;
        for(int i=0;i<n;i++){
            tempSum += w[i];
            prefixSum.add(tempSum);
        }
        totalSum = tempSum;

    }
    
    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum)+1;
        return upperBound(target);
    }

    private int upperBound(int target){
        int l = 0,h=prefixSum.size();
        while(l<=h){
            int mid = l + (h-l)/2;
            if(prefixSum.get(mid) < target){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */