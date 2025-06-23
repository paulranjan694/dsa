class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        partitionHelper(s,results,result,0);
        return results;
    }

    private void partitionHelper(String s,List<List<String>> results, List<String> result, int startPos){
        if(startPos >= s.length()){
            results.add(new ArrayList<>(result));
            return;
        }

        for(int endPos = startPos; endPos < s.length();endPos++){
            if(isPalindrome(s, startPos,endPos)){
                result.add(s.substring(startPos,endPos+1));
                partitionHelper(s,results,result,endPos+1);
                result.remove(result.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}