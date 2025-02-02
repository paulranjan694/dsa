class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1=nums1.length,n2=nums2.length;
        Queue<int[]> pq= new PriorityQueue<>((a,b) -> a[0]-b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        Set<Pair<Integer,Integer>> visistedPair = new HashSet<>();
        pq.add(new int[]{nums1[0]+nums2[0],0,0});
        visistedPair.add(new Pair<Integer,Integer>(0,0));
        while(k-- > 0 && !pq.isEmpty()){
            int[] top = pq.poll();
            int i = top[1];
            int j = top[2];
            ans.add(List.of(nums1[i],nums2[j]));

            if(i+1 <n1 && !visistedPair.contains(new Pair<Integer,Integer>(i+1,j))){
                pq.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
                visistedPair.add(new Pair<Integer,Integer>(i+1,j));
            }

            if(j+1 <n2 && !visistedPair.contains(new Pair<Integer,Integer>(i,j+1))){
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
                visistedPair.add(new Pair<Integer,Integer>(i,j+1));
            }
        }

        return ans;
    }
}