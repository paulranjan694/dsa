class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        int ans=1,end=intervals[0][1];
        for(int i=1;i<n;i++){
            if(end <= intervals[i][0]){
                ans++;
                end = intervals[i][1];
            }
        }
        return n-ans;
    }
}