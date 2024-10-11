class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0;i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms=0,minrooms=Integer.MIN_VALUE;
        for(int i=0,j=0;i<n && j<n;){
            if(start[i]<end[j]){
                rooms++;i++;
            }else{
                rooms--;j++;
            }
            minrooms=Math.max(minrooms,rooms);
        }
        return minrooms;
    }
}