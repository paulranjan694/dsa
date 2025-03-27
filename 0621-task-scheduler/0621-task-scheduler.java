class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        int t=0;
        Queue<int[][]> queue = new LinkedList<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(char c : tasks){
            chars[c-'A']++;
        }

        for(int i=0;i<26;i++){
            if(chars[i] > 0){
               maxHeap.add(chars[i]);
            }
        }



        while(!queue.isEmpty() || !maxHeap.isEmpty()){
            if(!maxHeap.isEmpty()){
                int ele = maxHeap.poll();
                if(ele -1 > 0){
                    int[][] temp = new int[1][2];
                    temp[0][0] = ele-1;
                    temp[0][1] = t+n;
                    queue.offer(temp);
                }
            }

            if(!queue.isEmpty() && queue.peek()[0][1] == t){
                maxHeap.add(queue.poll()[0][0]);
            }

            t++;
        }
        return t;

    }
}