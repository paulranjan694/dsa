class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long start=0,end=0;

        for(int e : batteries){
            start = Math.min(e,start);
            end += e;
        }
        
        end /= n;
        long res=-1;
        while(start <= end){
            long mid = (start+end)/2;
            if(ispossible(n, mid, batteries)){
                start = mid+1;
                res=mid;
            }else{
                end = mid-1;
            }
        }
        return res;
    }

    private boolean ispossible(int n, long time, int[] batteries){
        long total = 0;
        for(int b: batteries){
            total += Math.min(b, time);
        }

        return total >= n*time;
    }
}