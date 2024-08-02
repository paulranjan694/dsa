class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String str : details){
            int len = str.length()-1;
            int idx = len-3;
            String s="";
            for(;idx<len-1;idx++){
                s+=str.charAt(idx);
            }
            if(Integer.parseInt(s) > 60)
                ans++;
        }
        return ans;
    }
}