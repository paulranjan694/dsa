class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> digitMapping = new HashMap<>();
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            //result.add("");
            return result;
        }
        digitMapping.put('2',"abc");
        digitMapping.put('3',"def");
        digitMapping.put('4',"ghi");
        digitMapping.put('5',"jkl");
        digitMapping.put('6',"mno");
        digitMapping.put('7',"pqrs");
        digitMapping.put('8',"tuv");
        digitMapping.put('9',"wxyz");
        solve(digits,digitMapping,result,new StringBuilder(),0);
        return result;
    }

    private void solve(String digits,Map<Character,String> digitMapping,List<String> result, StringBuilder ds, int index){
        //base cond
        if(ds.length()==digits.length()){
            result.add(ds.toString());
            return;
        }

        String digitChars = digitMapping.get(digits.charAt(index));
        for(int j=0;j<digitChars.length();j++){
            ds.append(digitChars.charAt(j));
            solve(digits,digitMapping,result,ds,index+1);
            ds.deleteCharAt(ds.length()-1);
        }
        
    }
}