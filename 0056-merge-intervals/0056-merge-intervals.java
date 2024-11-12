//tc - nlogn + n
//sc - n

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        //int start=intervals[0][0], end=intervals[0][1];
        List<int[]> t = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            if(t.isEmpty() || t.get(t.size()-1)[1] < intervals[i][0]){
               t.add(intervals[i]);
            }else{
               t.get(t.size()-1)[1] = Math.max(t.get(t.size()-1)[1], intervals[i][1]);
            }
        }
       // t.add(new int[]{start,end});

        int[][] ans = new int[t.size()][2];
        for(int i=0;i<t.size();i++){
            ans[i] = t.get(i);
        }

        return ans;
    }
}