class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,right=0,max=0,n=fruits.length;
        //int[] hash = new int[100001];
        Map<Integer,Integer> hash = new HashMap<>();
        while(right < n){
            hash.put(fruits[right],hash.getOrDefault(fruits[right],0)+1);

            while(hash.size() > 2){
                hash.put(fruits[left],hash.get(fruits[left])-1);
                if(hash.get(fruits[left]) == 0){
                    hash.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}