class Solution {
    public int nextGreaterElement(int n) {
        char[] ar = ("" + n).toCharArray();

        int i=ar.length-2;
        while(i>=0 && ar[i+1]<=ar[i]){
            i--;
        }
        if(i<0){
            return -1;
        }
        int min=Integer.MAX_VALUE;
        int j=ar.length-1;
        while(j>=0 && ar[j]<=ar[i]){
            min=Math.min(min,ar[j]);
            j--;
        }

        swap(ar,i,j);
        reverse(ar,i+1);
        try {
            return Integer.parseInt(new String(ar));
        } catch (Exception e) {
            return -1;
        }
    }

    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}