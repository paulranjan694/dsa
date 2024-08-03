class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length) return false;
       int[] frequency = new int[1001];

        for(int i=0;i<target.length;i++){
            frequency[target[i]]++;
            frequency[arr[i]]--;
        }

        for(int i=0;i<1001;i++){
            if(frequency[i] != 0){
                return false;
            }
        }

        return true;
    }
}