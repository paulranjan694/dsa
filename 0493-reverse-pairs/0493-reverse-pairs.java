class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums,0,n-1);
    }

    public int mergeSort(int[] nums, int l, int h){
        //base case
        if(l>=h) return 0;
        int ans=0;
        int mid = (l+h)/2;

        ans += mergeSort(nums,l,mid);
        ans += mergeSort(nums,mid+1,h);
        ans += countPairs(nums,l, mid, h);
        merge(nums,l,mid,h);
        return ans;
    }

    public void merge(int[] arr, int l, int mid, int h){
        List<Integer> temp = new ArrayList<>();
        int i=l,j=mid+1;
        while(i<=mid && j<=h){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }

        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }

        while(j<=h){
            temp.add(arr[j]);
            j++;
        }
        int k=l;
        for(int e: temp){
            arr[k++] = e;
        }
    }

    public int countPairs(int[] arr, int l, int mid, int h){
        int left = l, right = mid+1;
        int cnt=0;
        while(left<=mid){
            while(right<=h && (long)arr[left] > (long)(2 * (long)arr[right])){
                right++;
            }
            cnt += (right - (mid +1));
            left++;
        }
        return cnt;
    }
}