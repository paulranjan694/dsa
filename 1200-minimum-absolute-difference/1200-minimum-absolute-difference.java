class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length, min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<n;i++){
            min = Math.min(min,arr[i]-arr[i-1]);
        }

        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1] == min){
                result.add(List.of(arr[i-1],arr[i]));
            }
        }

        return result;
    }
}