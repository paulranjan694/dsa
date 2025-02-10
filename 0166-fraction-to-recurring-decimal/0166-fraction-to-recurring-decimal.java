class Solution {
    public String fractionToDecimal(int n1, int d1) {
        StringBuilder ans = new StringBuilder();
        Map<Long,Integer> map = new HashMap<>();
        boolean num = false,deno=false;
        long n = n1,d=d1;
        if(n<0){
            n *= -1;
            num = true;
        }

        if(d<0){
            d *= -1;
            deno = true;
        }
        if(n!=0 && (num || deno)){
            ans.append("-");
        }
        if(num&&deno){
            ans.deleteCharAt(0);
        }
        long q = n/d;
        long r = n%d;
        ans.append(q);
        if(r!=0){
            ans.append(".");
            // r*=10;
            // q=r/d;
            // r %= d;
            // ans.append(q);
            while(r!=0){
                if(map.containsKey(r)){
                    int index = map.get(r);
                    ans.insert(index,"(");
                    ans.append(")");
                    break;
                }else{
                    map.put(r,ans.length());
                    r*=10;
                    q=r/d;
                    r %= d;
                    ans.append(q);
                }
            }
        }
        
        return ans.toString();
    }
}