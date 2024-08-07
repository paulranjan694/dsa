class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int t) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        utils(arr,t,res,sum,0,0);
        return res;
    }

    public void utils(int[] arr, int t,  List<List<Integer>> res,List<Integer> sum, int totalSum,int idx){
        if(idx==arr.length && totalSum==t){
            List<Integer> temp = new ArrayList<>();
            for(int e:sum){
                temp.add(e);
            }

            res.add(temp);
            return ;
        }
        if(totalSum > t || idx>=arr.length){
            return;
        }

        sum.add(arr[idx]);
        utils(arr,t,res,sum,totalSum+arr[idx],idx);
        sum.remove(sum.size()-1);
       
        utils(arr,t,res,sum,totalSum,idx+1);
    }
}