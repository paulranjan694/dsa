class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int e : candyType){
            set.add(e);
        }

        int n = candyType.length/2;
        int type = set.size();

        if(type >=n){
            return n;
        }
        return type;
    }
}