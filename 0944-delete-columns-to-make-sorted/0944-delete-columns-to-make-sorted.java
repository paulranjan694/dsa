class Solution {
    public int minDeletionSize(String[] strs) {
        int delCount=0, n=strs.length,m=strs[0].length();
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                char c1 = strs[j].charAt(i);
                char c2 = strs[j-1].charAt(i);
                if(c2>c1){
                    delCount++;
                    break;
                }
            }
        }

        return delCount;
    }
}