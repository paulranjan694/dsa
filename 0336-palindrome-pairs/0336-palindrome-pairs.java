class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String,Integer> mp = new HashMap<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            mp.put(words[i],i);
        }
        //System.out.println(mp);
        for(int w=0;w<n;w++){
            String word = words[w];
            for(int i=0;i<=word.length();i++){
                String prefix = word.substring(0,i);
                String suffix = word.substring(i);
                String revSuffix = new StringBuilder(suffix).reverse().toString();
                if(isPalindrome(prefix)){
                    if(mp.containsKey(revSuffix)){
                        int idx = mp.get(revSuffix);
                        if(w!=idx)
                            res.add(List.of(idx,w));
                    }
                }

                String revPrefix = new StringBuilder(prefix).reverse().toString();
                if(i != word.length() && isPalindrome(suffix)){
                    if(mp.containsKey(revPrefix)){
                        int idx = mp.get(revPrefix);
                        if(w!=idx)
                            res.add(List.of(w,idx));
                    }
                }
            }
        }
        return res;

    }

    private boolean isPalindrome(String s){
        int i=0,j=s.length()-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}