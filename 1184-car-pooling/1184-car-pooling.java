class Solution {
    //TC - O(n)
    //SC - O(n)
    public boolean carPooling(int[][] trips, int capacity) {
        int[] prefixCapacity = new int[1001];

        for(int[] arr: trips){
            prefixCapacity[arr[1]] += arr[0];
            prefixCapacity[arr[2]] -= arr[0];
        }
        int currPas = 0;
        for(int i = 0; i < 1001; i++){
            currPas += prefixCapacity[i];
            if(currPas > capacity) return false;
        }
        return true;
    }

    //TC - O(nlogn(sorting) + nlogn(heap))
    //SC - O(n)
    public boolean carPooling2(int[][] trips, int capacity) {
        int n = trips.length;

        Arrays.sort(trips,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] != b[1]){
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[2], b[2]);
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return Integer.compare(a[0], b[0]);
                }
            }
        );

        int curr = 0;
        for(int[] arr: trips){
            if(pq.isEmpty()){
                curr += arr[0];
                pq.add(new int[]{arr[2],arr[0]});
            }else{
                if(pq.peek()[0] > arr[1]){
                    pq.add(new int[]{arr[2],arr[0]});
                    curr += arr[0];
                }else{
                    while(!pq.isEmpty() && pq.peek()[0] <= arr[1]){
                        int[] t = pq.poll();
                        curr = curr - t[1];
                    }
                    curr += arr[0];
                    pq.add(new int[]{arr[2],arr[0]});
                }
            }
            if(curr > capacity) return false;
        }
        return true;
    }

}