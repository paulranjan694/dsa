class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length, minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<n;i++){
            int diff = arr[i]-arr[i-1];
            if(diff < minDiff){
                minDiff = diff;
                result.clear();
                result.add(List.of(arr[i-1],arr[i]));
            }else if(minDiff == diff){
                result.add(List.of(arr[i-1],arr[i]));
            }
        }

        return result;
    }
}