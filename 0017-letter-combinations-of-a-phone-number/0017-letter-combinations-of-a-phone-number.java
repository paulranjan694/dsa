class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        return utils(digits,map,0);
    }

    public List<String> utils(String s, Map<Character,String> map, int idx){
        if(idx==s.length()) return new ArrayList<String>();
        List<String> returnedList = utils(s,map,idx+1);
        List<String> ansList = new ArrayList<String>();
        String val = map.get(s.charAt(idx));
        if(returnedList.size() == 0){
            for(int i=0;i<val.length();i++){
                String str = val.charAt(i)+"";
                ansList.add(str);
            }
        }else{
            for(int i=0;i<val.length();i++){
                String str = val.charAt(i)+"";
                for(String r: returnedList){
                    String s1 = str+r;
                    ansList.add(s1);
                }
            }
        }
        return ansList;
    }
}