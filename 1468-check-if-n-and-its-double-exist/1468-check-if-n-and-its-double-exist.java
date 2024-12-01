class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int p = arr[i] *2;
            hm.putIfAbsent(p,i);
        }

        for(int i = 0;i<n;i++){
            int f = hm.getOrDefault(arr[i],-1);
            if(f>=0 && i != f) return true;
            // for(int j=0;j<n;j++){
            //     if(i!=j && arr[i]==2*arr[j]) return true;
            // }
        }
        return false;
    }
}