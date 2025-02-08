class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = lowerBound(arr,x);
        int n=arr.length;
        List<Integer> ans =  new ArrayList<>();
        int i=idx-1,j=idx;
        while(k > 0 && i >= 0 && j < n){
            int abs1 = Math.abs(arr[i]-x);
            int abs2 = Math.abs(arr[j]-x);
            if(abs1 <= abs2){
                ans.add(arr[i]);
                i--;
            }else{
                ans.add(arr[j]);
                j++;
            }
            k--;
        }

        while(k > 0 && i >= 0){
            ans.add(arr[i]);
            i--;
            k--;
        }

        while(k > 0 && j < n){     
            ans.add(arr[j]);
            j++; 
            k--;
        }

        Collections.sort(ans);
        return ans;
    }

    private int lowerBound(int[] arr, int target){
        int n=arr.length;
        int l=0,h=n-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            // if(arr[mid] == target) return mid;
            if(arr[mid] >= target){
                h = mid-1;
            }else{
                l=mid+1;
            }
        }
        // if(l>=0 && l<n && h>=0 && h<n){
        //     if(arr[l] < arr[h]){
        //         return l;
        //     }else{
        //         return h;
        //     }
        // }
        return l;
    }
}