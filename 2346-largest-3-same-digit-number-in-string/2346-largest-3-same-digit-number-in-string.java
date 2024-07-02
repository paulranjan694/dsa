class Solution {
    public String largestGoodInteger(String nums) {
        int l=0,r=0,n=nums.length();
        String ans="";
        while(r<n){
            r++;
            String s = nums.substring(l,r);
            if(s.length()==3){
                if(s.charAt(0) == s.charAt(2) && s.charAt(0) == s.charAt(1)){
                    if(ans==""){
                        ans=s;
                    }else{
                       if(ans.charAt(0) < s.charAt(0)){
                            ans=s;
                       }
                    }
                }

                l++;
            }
        }
        return ans;
    }
}