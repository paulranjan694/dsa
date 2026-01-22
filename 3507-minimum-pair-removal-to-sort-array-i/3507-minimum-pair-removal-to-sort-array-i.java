class Solution {
    public int minimumPairRemoval(int[] nums) {
        int minOp=0;

        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);    
        }

        while(!isSorted(list)){
            int min = Integer.MAX_VALUE, idx=-1;

            for(int i=1;i<list.size();i++){
                int sum = list.get(i) + list.get(i-1);
                if(min > sum){
                    idx=i;
                    min=sum;
                }
            }
            
            list.set(idx, min);
            list.remove(idx-1);
            minOp++;

        }
        return minOp;
    }

    private boolean isSorted(List<Integer> list){
        for(int i=1;i<list.size();i++){
            if(list.get(i) < list.get(i-1)){
                return false;
            }
        }
        return true;
    }
}