class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int left=0,right=0,sum=0,n=nums.length,idx=0;
        int[] res = new int[n-k+1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] a, int[] b) -> {
            if(a[1]==b[1]) return b[0]-a[0];
            else return b[1]-a[1];
        });

        Map<Integer,Integer> hash = new HashMap<>();

        while(right<k){
            hash.put(nums[right], hash.getOrDefault(nums[right], 0)+1);
            right++;
        }

        for(Map.Entry<Integer,Integer> entry : hash.entrySet()){
            int[] temp = new int[2];
            temp[0] = entry.getKey();
            temp[1] = entry.getValue();
            heap.add(temp);
        }
        int t_x=x;
        while(t_x-- > 0 && heap.size() > 0){
            int[] t_arr = heap.poll();
            sum += t_arr[0]*t_arr[1];
        }

        res[idx++] = sum;
        sum=0;

        while(right < nums.length){
            hash.put(nums[left], hash.getOrDefault(nums[left++],0)-1);
            //if(hash.get(nums[left]) <= 0) hash.remove(nums[left]);
            
            hash.put(nums[right], hash.getOrDefault(nums[right], 0)+1);
            right++;

            heap = new PriorityQueue<>((int[] a, int[] b) -> {
                if(a[1]==b[1]) return b[0]-a[0];
                else return b[1]-a[1];
            });

            for(Map.Entry<Integer,Integer> entry : hash.entrySet()){
                int[] temp = new int[2];
                temp[0] = entry.getKey();
                temp[1] = entry.getValue();
                heap.add(temp);
            }
            t_x=x;
            while(t_x-- > 0 && heap.size() > 0){
                int[] t_arr = heap.poll();
                sum += t_arr[0]*t_arr[1];
            }

            res[idx++] = sum;
            sum=0;
        }
        return res;
    }
}