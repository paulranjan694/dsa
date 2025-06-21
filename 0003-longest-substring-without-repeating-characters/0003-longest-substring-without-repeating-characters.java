class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Set<Character> visited = new HashSet<>();
        int left=0,right=0,n=arr.length,maxlen=0;

        while(right < n){
            while(visited.contains(arr[right])){
                visited.remove(arr[left]);
                left++;
            }
            visited.add(arr[right]);
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
}