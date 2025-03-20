class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for(String s : strs){
            char[] charr = s.toCharArray();
            Arrays.sort(charr);
            String str = new String(charr);

            if(mp.containsKey(str)){
                mp.get(str).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                mp.put(str,list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : mp.entrySet()){
            result.add(entry.getValue());
        }
        return result;


    }
}