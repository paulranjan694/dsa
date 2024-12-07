class Solution {
    public int numberOfSubstrings(String s) {
       int n = s.length(),l=0,r=0,count=0;
        int a = -1,b=-1,c=-1;
        while(r<n){
            char ch = s.charAt(r);
            if(ch=='a'){
                a=r;
            }else if(ch == 'b'){
                b=r;
            }else{
                c=r;
            }
            
            if(a!=-1 && b!=-1 &&c !=-1){
                int minIdx = Math.min(a,Math.min(b,c));
                count += minIdx+1;
            }
            r++;
        }
        return count;
    }
}