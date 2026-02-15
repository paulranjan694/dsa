class Solution {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i=arr1.length-1, j=arr2.length-1, carry=0;

        while(i>=0 && j>=0){
            if(arr1[i]=='1' && arr2[j]=='1'){
                if(carry==1){
                    sb.append(1);
                    carry=1;
                }else{
                    sb.append(0);
                    carry=1;
                }
            }else if(arr1[i]=='1' || arr2[j]=='1'){
                if(carry==1){
                    sb.append(0);
                    carry=1;
                }else{
                    sb.append(1);
                    carry=0;               
                }
            }else{
                if(carry==1){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                carry=0;               
            }
            i--;j--;
        }

        while(i>=0){
            if(arr1[i]=='1'){
                if(carry==1){
                    sb.append(0);
                    carry=1;
                }else{
                    sb.append(1);
                    carry=0;
                }
            }else{
                if(carry==1){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                carry=0;               
            }
            i--;
        }

        while(j>=0){
            if(arr2[j]=='1'){
                if(carry==1){
                    sb.append(0);
                    carry=1;
                }else{
                    sb.append(1);
                    carry=0;
                }
            }else{
                if(carry==1){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                carry=0;               
            }
            j--;
        }


        if(carry == 1)
            sb.append(carry);

        return sb.reverse().toString();
    }
}