class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:paths){
            String[] path=s.split(" ");
            String dir = "";
            for(String str : path){
                if(dir.length() == 0){
                    dir=str;
                }else{
                    String[] temp=str.split("\\(");
                    String file = temp[0];
                    String content = temp[1].substring(0,temp[1].length()-1);
                    String newpath = dir+"/"+file;
                    if(map.containsKey(content)){
                        List<String> list = map.get(content);
                        list.add(newpath);
                        map.put(content,list);
                    }else{
                        List<String> list = new ArrayList<>();
                        list.add(newpath);
                        map.put(content,list);
                    }
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1)
                ans.add(entry.getValue());
        }
        return ans;
    }
}