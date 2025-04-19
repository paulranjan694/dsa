class Pair implements Comparable<Pair>{
    int a,b,idx;
    Pair(int a, int b, int idx){
        this.a=a;
        this.b=b;
        this.idx=idx;
    }

    @Override
    public int compareTo(Pair p){
        if(this.a == p.a){
            return this.idx-p.idx;
        }
        return this.a - p.a;
    }


}
class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        List<Pair> list = new ArrayList<>();
        int n = nums1.length;

        for(int i=0;i<n;i++){
            list.add(new Pair(nums1[i],nums2[i],i));
        }

        Collections.sort(list);

        long[] res = new long[n];
        Queue<Integer> pq = new PriorityQueue<>();
        long sum=0;
        for(int i=0;i<n;i++){
            Pair p = list.get(i);
            if(i==0){
                pq.add(list.get(i).b);
                res[p.idx]=0;
                sum+=list.get(i).b;
            }else{   
                res[p.idx] = sum;
                pq.add(list.get(i).b);
                sum += list.get(i).b;
                if(list.get(i-1).a == p.a){
                    res[p.idx] = res[list.get(i-1).idx];
                }
                while(pq.size() > k){
                    sum-=pq.poll();
                }    
            }
        }

        return res;
    }
}