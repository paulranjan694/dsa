class Solution {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i=arr1.length-1, j=arr2.length-1, carry=0;

        while(i>=0 || j>=0 || carry==1){
            int sum = carry;

            if(i>=0){
                sum += arr1[i]-'0';
                i--;
            }

            if(j>=0){
                sum += arr2[j]-'0';
                j--;
            }

            sb.append(sum%2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}