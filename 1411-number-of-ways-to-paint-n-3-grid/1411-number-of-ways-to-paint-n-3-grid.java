/**
    0 - empty
    1 - red
    2 - yellow
    3 - green

 */

class Solution {
    int mod = 1_000_000_007;
    public int numOfWays(int n) {
        int[] prevRow = new int[3];
        int ans = 0;
        Map<String, Integer> memo = new HashMap<>();

        for(int k = 1;k<=3;k++){//assigning color to row - 0 
            prevRow[0] = k;
            ans = (ans + dfsMemo(prevRow,0,1,k,n, memo)) % mod;
        }
        
        return ans;
    }

    private int dfsMemo(int[] prevRow, int r, int c, int skipColor, int n, Map<String, Integer> memo){
        if(c==3) {
            if(r==n-1){
                return 1;
            }else{
                return dfsMemo(prevRow,r+1,0,0, n, memo);
            }
        }

        if(r>=n) return 0;
        String key = r+"-"+c+"-"+skipColor+"-"+prevRow[0]+"-"+prevRow[1]+"-"+prevRow[2];
        if(memo.containsKey(key)) return memo.get(key);
        int ways=0;

        for(int color = 1;color<=3;color++){//color
            if(color==skipColor) continue;
            if(r > 0 && prevRow[c]==color) continue;
            int old = prevRow[c];
            prevRow[c] = color;
            ways = (ways + dfsMemo(prevRow,r,c+1,color,n,memo)) % mod;
            prevRow[c] = old;
        }
        memo.put(key, ways);
        return ways;   
    }
}