class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n1 = firstList.length, n2 = secondList.length,i=0,j=0;
        List<int[]> res = new ArrayList<>();
        while(i<n1 && j<n2){
          int s1 = firstList[i][0],s2 = secondList[j][0],e1=firstList[i][1],e2=secondList[j][1];
          if((s1 <= s2 && s2 <= e1) || (s2 <= s1 && s1 <= e2)){
              int[] temp = new int[2];
              temp[0] = Math.max(s1,s2);
              temp[1] = Math.min(e1,e2);
              res.add(temp);
          }
          
          if(e1 <= e2){
            i++;
          }else{
            j++;
          }
        }
        return res.toArray(new int[][]{});
    }
}