class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> partitions = new ArrayList<>();
        solve(s,0,res,partitions);
        return res;
    }

    private void solve(String s, int start, List<List<String>> res, List<String> partitions){
        if(start >= s.length()){
            res.add(new ArrayList<>(partitions));
            return;
        }
        for(int end = start;end<s.length();end++){
            if(isPalindrome(s,start,end)){
                partitions.add(s.substring(start,end+1));
                solve(s,end+1,res,partitions);
                partitions.remove(partitions.size()-1);
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