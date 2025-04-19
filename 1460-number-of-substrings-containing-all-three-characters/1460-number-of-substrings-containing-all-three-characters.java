class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0,l=0,r=0,n=s.length();
        int[] map = new int[3];
        char[] arr = s.toCharArray();

        while(r<n){
            map[arr[r] - 'a']++;
            while(containsAllChars(map)){
                count += n-r;
                map[arr[l]-'a']--;
                l++;
            }

            r++;
        }
        return count;
    }

    private boolean containsAllChars(int[] map){
        return map[0] > 0 && map[1] > 0 && map[2] > 0;
    }
}