class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int start=intervals[0][0], end=intervals[0][1];
        List<int[]> t = new ArrayList<>();
        for(int i = 1;i<intervals.length;i++){
            if(end >= intervals[i][0]){
                if(end < intervals[i][1]) end = intervals[i][1];
            }else{
                t.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        t.add(new int[]{start,end});

        int[][] ans = new int[t.size()][2];
        for(int i=0;i<t.size();i++){
            int[] a = t.get(i);
            ans[i][0] = a[0];
            ans[i][1] = a[1];
        }

        return ans;
    }
}