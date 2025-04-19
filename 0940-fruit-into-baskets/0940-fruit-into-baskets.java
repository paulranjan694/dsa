class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0,r=0,max=0,temp=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<n){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);

            while(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }

            max = Math.max(max,r-l+1);
            r++;
        }


       return max;
    }
}