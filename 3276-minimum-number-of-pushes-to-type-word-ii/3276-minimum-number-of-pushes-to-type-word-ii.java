class Solution {
    static class SortHelper implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b){
                return Integer.compare(b,a);
        }
    }
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
            if( i>=0 && i<=7){
                sum+= list.get(i);
            }else if(i>=7 && i<=15){
                sum+= (list.get(i)*2);
            }else if(i>=16 && i<=23){
                sum+= (list.get(i)*3);
            }else {
                sum+= (list.get(i)*4);
            }
        }
        return sum;
    }
}