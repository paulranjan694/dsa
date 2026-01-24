class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int idx=0;
        while(list.size()>1){
            idx += k-1;
            idx %= Math.min(list.size(),n);

            list.remove(idx);
        }
        return list.get(0);
    }
}