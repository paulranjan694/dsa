class SortCom implements Comparator<int[]>{
    @Override
    public int compare(int[] a, int[] b){
        if(a[1]==b[1]){
            return b[0]-a[0];
        }
        return b[1]-a[1];
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> maxheap = new PriorityQueue<>(new SortCom());
        for(int i=0;i<mat.length;i++){
            int count = upperBound(mat[i]);
            int[] temp = new int[2];
            temp[0] = i;
            temp[1] = count;
            maxheap.add(temp);

            if(maxheap.size() > k){
                maxheap.poll();
            }
        }

        int[] ans = new int[k];
        while(!maxheap.isEmpty()){
            ans[--k] = maxheap.poll()[0];
        }

        return ans;
    }

    private int upperBound(int[] arr){
        int l=0,h=arr.length-1;
        int maxCount = 0;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]==1){
                maxCount = Math.max(maxCount,mid+1);
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return maxCount;
    }
}