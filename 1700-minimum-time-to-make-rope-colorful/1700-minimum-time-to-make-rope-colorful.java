class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        char[] arr = colors.toCharArray();
        int idx=1;
        while(idx < arr.length){
            if(arr[idx-1] == arr[idx]){
                int max=neededTime[idx-1],sum=neededTime[idx-1],t_idx=idx;
                while(t_idx < arr.length && arr[idx-1] == arr[t_idx]){
                    max=Math.max(max, neededTime[t_idx]);
                    sum += neededTime[t_idx];
                    t_idx++;
                }
                minTime += (sum-max);
                idx=t_idx;
            }else idx++;
        }

        return minTime;
    }
}