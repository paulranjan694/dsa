class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(beginWord,1));

        while(!queue.isEmpty()){
            Pair p = queue.poll();

            String word = p.word;
            int level = p.level;
            if(word.equals(endWord)){
                return level;
            }
            

            for(int j=0;j<word.length();j++){
                StringBuilder sb = new StringBuilder(word);
                for(int i=0;i<26;i++){
                    sb.setCharAt(j, (char)(97+i));
                    String t = sb.toString();
                    //System.out.println(t);
                    if(set.contains(t)){
                        set.remove(t);
                        queue.offer(new Pair(t,level+1));
                    }
                }
            }
            
        }
        return 0;
    }
}

class Pair{
    String word;
    int level;

    Pair(String s, int l){
        word=s;
        level=l;
    }
}