class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];

        char[] arr = s.toCharArray();
        int left=0,right=0,n=arr.length,maxLen=0;

        while(right < n){
            //System.out.println("char -->"+arr[right]+" -- "+"index -->"+right);
            hash[arr[right]-'A']++;
            while(right-left+1 - maxFreq(hash) > k){
               // System.out.println("inside while");
                //System.out.println("left char -->"+arr[left]+" -- "+"left index -->"+left);
                hash[arr[left]-'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }  
        return maxLen;
    }

    private int maxFreq(int[] hash){
        int max=0,maxIdx=-1;
        for(int i=0;i<26;i++){
           max=Math.max(hash[i],max);
        }
        //System.out.println("max char freq -->"+(char)(maxIdx + 'A'));
        return max;
    }
}