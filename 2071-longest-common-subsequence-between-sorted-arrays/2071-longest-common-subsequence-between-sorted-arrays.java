class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        Map<Integer,Integer> hm = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int n = arrays.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<arrays[i].length;j++){
                int f = hm.getOrDefault(arrays[i][j],0);
                hm.put(arrays[i][j],f+1);
            }
        }

        for(Integer k : hm.keySet()){
            if(hm.get(k) == n)
                res.add(k);
        }
        Collections.sort(res);
        return res;
    }
}