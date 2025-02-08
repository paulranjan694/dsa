class SortCom implements Comparator<int[]>{
    @Override
    public int compare(int[] a, int[] b){
        if(a[0]==b[0]){
            return b[1]-a[1];
        }
        return b[0]-a[0];
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<int[]> maxheap = new PriorityQueue<>(new SortCom());

        for(int i=0;i<arr.length;i++){
            int[] temp = new int[2];
            temp[0] = Math.abs(arr[i]-x);
            temp[1]=arr[i];
            maxheap.add(temp);
            if(maxheap.size() > k){
                maxheap.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!maxheap.isEmpty()){
            ans.add(maxheap.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }
}