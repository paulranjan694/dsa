class Solution {
    public String nextPalindrome(String num) {
        int n = num.length();
        int mid = n/2;
        if(n==1) return "";

        char[] arr = num.toCharArray();

        if(!findNextPermutation(arr,mid)) return "";

         for(int i=0,j=n-1;i<j;i++,j--){
            arr[j]=arr[i];
        }
        return new String(arr);
    }

    private boolean findNextPermutation(char[] arr, int len){
        int flag=-1;
        int i=len-2;
        while(i>=0){
            if(arr[i] < arr[i+1]){
                flag=0;
                break;
            }
            i--;
        }

        if(flag==-1) return false;

        int j = len-1;
        while(j>=0 && arr[j]<=arr[i]){
            j--;
        }

       //swap
       char c = arr[i];
       arr[i]=arr[j];
       arr[j]=c;
        //reverse except first character
        for(i=i+1,j=len-1;i<j;i++,j--){
            c = arr[i];
            arr[i]=arr[j];
            arr[j]=c;
        }

        return true;
    }
}