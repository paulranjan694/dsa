class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> listInterVals = new ArrayList<>();
        if(intervals.length == 0){
            int[][] r = new int[1][2];
            r[0][0] = newInterval[0];
            r[0][1] = newInterval[1];
            return r;
        }

        
        boolean inserted=false;
        for(int i=0;i<intervals.length;i++){
            if(intervals[0][1] >= newInterval[0] && !inserted){
                listInterVals.add(newInterval);
                inserted=true;
            }
            if(intervals[i][1] <= newInterval[0]){
                listInterVals.add(intervals[i]);
            }else{
                if(!inserted){
                    listInterVals.add(newInterval);
                    inserted=true;
                }
                listInterVals.add(intervals[i]);
            }
        }

        if(listInterVals.get(listInterVals.size()-1)[1] <= newInterval[1]){
            listInterVals.add(newInterval);
        }

       // Collections.sort(listInterVals,(a,b) -> a[0]-b[0]);

        List<int[]> tempRes = new ArrayList<>();
        tempRes.add(listInterVals.get(0));

        for(int i=1;i<listInterVals.size();i++){
            if(tempRes.get(tempRes.size()-1)[1] >= listInterVals.get(i)[0]){
                tempRes.get(tempRes.size()-1)[0] = Math.min(tempRes.get(tempRes.size()-1)[0],listInterVals.get(i)[0]);
                tempRes.get(tempRes.size()-1)[1] = Math.max(tempRes.get(tempRes.size()-1)[1],listInterVals.get(i)[1]);
            }else{
                tempRes.add(listInterVals.get(i));
            }
        }

        int[][] res = new int[tempRes.size()][2];
        int index=0;
        for(int[] ar : tempRes){
            res[index++]=ar;
        }

        return res;
    }
}