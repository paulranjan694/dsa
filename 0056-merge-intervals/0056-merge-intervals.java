class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(int[] a, int[] b)-> a[0]-b[0]);
        int n = intervals.length;
        list.add(intervals[0]);

        for(int i=1;i<n;i++){
            int[] lastInterval = list.get(list.size()-1);
            if(lastInterval[1] >= intervals[i][0]){
               lastInterval[1] = Math.max(lastInterval[1],intervals[i][1]);
            }else{
                list.add(intervals[i]);
            }
        }
        int[][] ans = new int[list.size()][2];
        int i=0;
        for(int[] interval : list){
            ans[i] = interval;
            i++;
        }
        return ans;
    }
}