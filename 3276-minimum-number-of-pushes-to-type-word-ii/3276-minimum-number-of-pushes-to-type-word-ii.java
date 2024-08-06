class Solution {
    public int minimumPushes(String word) {
       int[] freq = new int[26];

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            freq[ch-'a']++;
        }

        List<Integer> list = new ArrayList<>();
        for(int i : freq){
            if(i!=0) list.add(i);
        }

        Collections.sort(list,Collections.reverseOrder());
        int sum=0;
        for(int i=0;i<list.size();i++){
           sum+= (((i/8)+1 )* list.get(i));
        }
        return sum;
    }
}