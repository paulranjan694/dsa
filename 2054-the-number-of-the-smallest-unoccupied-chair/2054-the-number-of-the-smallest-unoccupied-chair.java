class Info{
    int arr,dep,idx;
    Info(int arr, int dep, int idx){
        this.arr = arr;
        this.dep = dep;
        this.idx = idx;
    }
}

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        Queue<Integer> availableChairs = new PriorityQueue<Integer>();
        Queue<int[]> blockedChairs = new PriorityQueue<>((a,b) -> a[0]-b[0]); // chair and dept time of person
        List<Info> lists = new ArrayList<>();

        //fill available chairs
        for(int i=0;i<n;i++){
            availableChairs.add(i);
        }

        //prepare the list for sorting
        for(int i=0;i<n;i++){
           lists.add(new Info(times[i][0], times[i][1],i));
        }

        Collections.sort(lists,(a,b) -> a.arr - b.arr);

        //done for 0th index 
        int chairIndex = availableChairs.poll();
        int[] tempArr = new int[2];
        tempArr[0] = lists.get(0).dep;
        tempArr[1] = chairIndex;
        blockedChairs.add(tempArr);

        for(int i=1;i<n;i++){
            Info info = lists.get(i);

            int arrival = info.arr;
            int departure = info.dep;
            int currIdx = info.idx;

            while(!blockedChairs.isEmpty() && blockedChairs.peek()[0] <= arrival){
                int[] temp = blockedChairs.poll();
                availableChairs.add(temp[1]);
            }

            int chIdx = availableChairs.poll();
            int[] tempAr = new int[]{departure,chIdx};
            blockedChairs.add(tempAr);

            if(currIdx == targetFriend){
                return chIdx;
            }

        }




        return 0;
    }
}