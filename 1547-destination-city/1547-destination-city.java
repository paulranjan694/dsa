class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,String>  map = new HashMap<>();

        String ans="";
        for(List<String> s:paths){
            map.put(s.get(0),s.get(1));
        }

        String source = paths.get(0).get(0);
        while(map.containsKey(source)){
            source = map.get(source);
            ans=source;
        }

        return ans;


    }
}