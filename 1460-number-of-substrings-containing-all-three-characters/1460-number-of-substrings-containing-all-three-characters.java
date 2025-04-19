class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0,l=0,r=0,n=s.length();
        Map<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size() == 3){
                count += n-r;
                char c = arr[l];
                map.put(c,map.get(c)-1);
                if(map.get(c) == 0){
                    map.remove(c);
                }

                
                l++;
            }

            r++;
        }
        return count;
    }
}