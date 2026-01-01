class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> temp = new ArrayList<>();
        int n = digits.length;
        int carry = 0;
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                if(digits[i]==9){
                    temp.add(0);
                    carry=1;
                }else{
                    int t = digits[i] + 1;
                    temp.add(t);
                    carry=t/10;
                }
            }else{
                int t = digits[i] + carry;
                temp.add(t%10);
                carry=t/10;    
            }
            
        }

        if(carry > 0){
            temp.add(carry);
        }

        int[] res = new int[temp.size()];
        int rIdx = res.length-1;
        for(int i=0;i< res.length;i++){
            res[rIdx--] = temp.get(i);
        }

        return res;
    }
}