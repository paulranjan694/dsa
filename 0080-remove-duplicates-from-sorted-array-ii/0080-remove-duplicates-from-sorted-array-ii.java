class Solution {
    public int removeDuplicates(int[] arr) {
        int i=1,j=1,eleCount=1,n=arr.length;
        while(i<n && j<n){
            if(arr[j-1]==arr[j]){
                if(eleCount < 2){
                    arr[i]=arr[j];
                    i++;
                    eleCount++;
                }
            }else{
                eleCount=0;
                arr[i]=arr[j];
                i++;
                eleCount++;
            }
            j++;
        }
        return i;
    }
}