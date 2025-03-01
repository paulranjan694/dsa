class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,right=0,max=0,n=fruits.length,temp=0;
        //int[] hash = new int[100001];
        Map<Integer,Integer> hash = new HashMap<>();
        while(right < n){
            if(hash.containsKey(fruits[right])){
                hash.put(fruits[right],hash.get(fruits[right])+1);
                temp+=1;
            }else{
                while(hash.size() >= 2){
                    int freq = hash.get(fruits[left]);
                    if(freq > 1){
                        hash.put(fruits[left],freq - 1);
                    }else{
                        hash.remove(fruits[left]);
                    }
                    temp -= 1;
                    left++;
                }
                hash.put(fruits[right],1);
                temp++;
            }
            max = Math.max(max,temp);
            right++;
        }
        return max;
    }
}