class Solution {
    public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<List<Integer>> list = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end = Math.max(end,intervals[i][1]);
            }else{
                list.add(Arrays.asList(start,end));
                start = intervals[i][0];end=intervals[i][1];
            }
        }
        list.add(Arrays.asList(start,end));
        int[][] res = new int[list.size()][2];
        int i=0;
        for(List<Integer> e:list){
            res[i][0]=e.get(0);
            res[i][1]=e.get(1);
            i++;
        }
        return res;
    }
}