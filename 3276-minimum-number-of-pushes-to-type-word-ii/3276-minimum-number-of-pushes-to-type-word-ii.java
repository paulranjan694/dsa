class Solution {
    public int minimumPushes(String word) {
       int[] freq = new int[26];

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            freq[ch-'a']++;
        }

        Arrays.sort(freq);
        int[] sortedFreq = new int[26];

        for(int i=0;i<26;i++){
            sortedFreq[i] = freq[25-i];
        }

        // List<Integer> list = new ArrayList<>();
        // for(int i : freq){
        //     if(i!=0) list.add(i);
        // }

        // Collections.sort(list,Collections.reverseOrder());
        int sum=0;
        for(int i=0;i<sortedFreq.length;i++){
           sum+= (((i/8)+1 )* sortedFreq[i]);
        }
        return sum;
    }
}