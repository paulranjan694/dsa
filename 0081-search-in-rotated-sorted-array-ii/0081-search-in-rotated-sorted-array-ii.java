class Solution {
    public boolean search(int[] arr, int target) {
        int l=0,h=arr.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]==target) return true;

            while(l<mid && arr[mid] == arr[l]){
                l++;
            }
            while(h > mid && arr[mid] == arr[h]){
                h--;
            }
            
            if(arr[l] <= arr[mid]){
                if(target >= arr[l] && target <= arr[mid]){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(target >= arr[mid] && target <= arr[h]){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return false;
    }
}