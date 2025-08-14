class Solution {
    public String largestGoodInteger(String num) {
        int l=0,r=0,n=num.length();
        if(n<3) return "";
        String res = "";
        while(r<n){
            r++;
            String temp = num.substring(l,r);
            if(temp.length()==3){
                if(temp.charAt(0) == temp.charAt(1) && temp.charAt(0) == temp.charAt(2)){
                    if(res.length()==0){
                        res=temp;
                    }else if(res.charAt(0) < temp.charAt(0)){
                        res = temp;
                    }
                }
                l++;
            }
        }
        return res;
    }
}