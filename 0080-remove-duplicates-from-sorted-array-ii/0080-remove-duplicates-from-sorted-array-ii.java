class Solution {
    public int removeDuplicates(int[] arr) {
       int i=1,j=1,eleCount=1,n=arr.length;
        while(i<n && j<n){
            if(arr[j-1]!=arr[j]){
                    arr[i]=arr[j];
                    i++;
                    eleCount=1;
            }else if(eleCount<2){
                arr[i]=arr[j];
                i++;
                eleCount++;
            }
            j++;
        }
        return i;
    }
}