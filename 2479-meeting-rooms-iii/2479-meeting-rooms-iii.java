class Pair{
  int end,room;
  Pair(int e, int r){
    this.end=e;
    this.room=r;
  }
}

class PairComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair a, Pair b){
        if(a.end == b.end)
            return a.room - b.room;
        return a.end-b.end;
    }
}

class SortCom implements Comparator<int[]>{
    @Override
    public int compare(int[] a, int[] b){
        if(a[0] == b[0])
            return a[1] - b[1];
        return a[0] - b[0];
    }
}

class Solution {
    public int mostBooked(int rooms, int[][] meetings) {
        int[] meetingroom = new int[rooms];
        
        Arrays.sort(meetings,new SortCom());
        Queue<Pair> queue = new PriorityQueue<>(new PairComparator());
        Queue<Integer> roomqueue = new PriorityQueue<>((a,b) -> a-b);
        for(int i=0;i<rooms;i++){
            roomqueue.add(i);
        }
        queue.offer(new Pair(meetings[0][1],roomqueue.peek()));
        meetingroom[roomqueue.poll()]++;
        
        int i=1,time=0;
        while(!queue.isEmpty() && i < meetings.length){
            while(!queue.isEmpty() && queue.peek().end <= meetings[i][0]){
                Pair p = queue.poll();
                roomqueue.offer(p.room);
                time=Math.max(time,p.end);
            }

            if(roomqueue.size() > 0){
                Pair pair = new Pair(meetings[i][1],roomqueue.peek());
                queue.offer(pair);
                meetingroom[roomqueue.poll()]++;
                i++;
            }else{
                Pair p = queue.poll();
                int endtime = p.end;
                roomqueue.offer(p.room);
                Pair pair = new Pair(meetings[i][1] - meetings[i][0] + endtime,roomqueue.peek());
                queue.offer(pair);
                meetingroom[roomqueue.poll()]++;
                i++;
            }

        }
        
        int ans=-1,max=-1;
        for(i=0;i<rooms;i++){
          if(max<meetingroom[i]){
            ans=i;
            max=meetingroom[i];
          }
        }
        return ans;
    }
}