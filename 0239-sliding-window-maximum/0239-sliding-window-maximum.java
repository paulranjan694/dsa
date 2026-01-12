class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.add(i);
        }
        
        res.add(arr[dq.peekFirst()]);
        
        for(int i=k;i<n;i++){
            
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            res.add(arr[dq.peekFirst()]);
        }

        int[] answer = new int[res.size()];

        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}