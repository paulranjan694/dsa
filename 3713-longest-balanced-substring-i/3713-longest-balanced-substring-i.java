class Solution {
    public int longestBalanced(String s) {
        int[] freq = new int[26];

        int n=s.length(),max=0;
        char[] arr = s.toCharArray();

        for(int i=0;i<n;i++){
            Arrays.fill(freq, 0);

            for(int j=i;j<n;j++){
                freq[arr[j]-'a']++;
                boolean flag = true;

                for(int x=0;x<26;x++){
                    if(freq[x] > 0 && freq[x] != freq[arr[j]-'a']){
                        flag=false;
                        break;
                    } 
                }

                if(flag){
                    max = Math.max(max,j-i+1);
                }
            }
        }

       
        return max;
    }
}