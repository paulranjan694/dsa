/**
tc -> "a@b$5!a8alskj234jasdf*()@$&%&#FJAvjjdaurNNMa8ASDF-0321jf?>{}L:fh"
constraints - s contains all characters, lower, uper,digit,symbol
 */

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //int[] hash = new int[128];
        Map<Character,Integer> hash = new HashMap<>();
        int n = s.length(),l=0,r=0,max=0;
        char[] arr = s.toCharArray();

        while(r<n){
            hash.put(arr[r],hash.getOrDefault(arr[r],0)+1);
            while(hash.size() > k){
                hash.put(arr[l],hash.get(arr[l])-1);
                if(hash.get(arr[l]) == 0){
                    hash.remove(arr[l]);
                }
                l++;
            }
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
    // private boolean containsMoreThanKDistinctChar(int[] hash, int k){
    //     for(int i=0;i<128;i++){
    //         if(hash[i] > 0){
    //             k--;
    //             if(k<0){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }


}