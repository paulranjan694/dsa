class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int e :arr){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(Integer key : map.keySet()){
            if(set.contains(map.get(key))){
                return false;
            }
            set.add(map.get(key));
        }
        return true;
    }
}