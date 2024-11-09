class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 1){
           
           
        }

        for(int i=1;i<=numRows;i++){
            List<Integer> temp = new ArrayList<>();
            if(i==1 || i==2){
                for(int j=0;j<i;j++){
                    temp.add(1);
                }
            }else{
                for(int j=0;j<i;j++){
                    if(j==0 || j==i-1){
                        temp.add(1);
                    }else{
                        int val = res.get(i-2).get(j-1) + res.get(i-2).get(j);
                        temp.add(val);
                    }
                }
            }
            res.add(temp);
        }

        return res;
    }
}