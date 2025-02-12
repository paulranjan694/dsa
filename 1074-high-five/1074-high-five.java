class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] item : items){
            if(map.containsKey(item[0])){
                List<Integer> list = map.get(item[0]);
                list.add(item[1]);
                map.put(item[0],list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(item[1]);
                map.put(item[0],list);
            }
        }

        int[][] ans = new int[map.size()][2];
        int idx=0;
        for(Integer key : map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list,Collections.reverseOrder());
            int total = 0;
            for(int i=0;i<5;i++){
                total += list.get(i);
            }
            int avg = total/5;
            ans[idx][0] = key;
            ans[idx][1] = avg;
            idx++;
        }

        Arrays.sort(ans,(a,b) -> a[0]-b[0]);
        return ans;


    }
}