class Solution {
    public String alienOrder(String[] words) {
        Map<Character,Integer> map = new HashMap<>();
        int idx=0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char ch = words[i].charAt(j);
                if(!map.containsKey(ch))
                    map.put(ch,idx++);
            }
        }
        int n = map.size();
        Map<Character,Integer> indegree = new HashMap<>();
        Map<Character, ArrayList<Character>> adj = new HashMap<>();

        for(Map.Entry<Character,Integer> m : map.entrySet()){
            adj.put(m.getKey(),new ArrayList<>());
            indegree.put(m.getKey(),0);
        }

        for(int i=0;i<words.length - 1;i++){
            boolean isDifFound = false;
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int j=0;j<len;j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    ArrayList list = adj.get(s1.charAt(j));
                    list.add(s2.charAt(j));
                    adj.put(s1.charAt(j),list);
                    //adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    indegree.put(s2.charAt(j), indegree.get(s2.charAt(j)) + 1);
                    isDifFound = true;
                    break;
                }
            }

            if(!isDifFound && s1.length() > s2.length()) return "";
        }

        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character,Integer> e : indegree.entrySet()){
            if(indegree.get(e.getKey()) == 0){
                q.add(e.getKey());
            }
        }

        StringBuilder sb = new StringBuilder("");

        while(!q.isEmpty()){
            char node = q.poll();
            sb.append(node);
            for(char nbr : adj.get(node)){
              indegree.put(nbr,indegree.get(nbr) -1);
                if(indegree.get(nbr) == 0){
                    q.add(nbr);
                }
            }
        }

        if(sb.length() != n) return "";

        return sb.toString();
    }
}