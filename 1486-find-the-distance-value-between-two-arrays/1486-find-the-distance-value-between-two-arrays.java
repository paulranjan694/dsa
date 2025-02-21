class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        //Arrays.sort(arr1);
        Arrays.sort(arr2);

        int count=0;
        for(int i=0;i<arr1.length;i++){
            if(bsearch(arr2,arr1[i],d)){
                count++;
            }
        }
        return count;
    }

    private boolean bsearch(int[] arr,int target, int d){
        int low = 0,high = arr.length-1;
        boolean valid = true;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                valid=false;
                break;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        if(low < arr.length && Math.abs(arr[low] - target) <= d){
            valid = false;
        }

        if(high >= 0 && Math.abs(arr[high] - target) <= d){
            valid = false;
        }

        return valid ? true : false;
    }
}