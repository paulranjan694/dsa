class Solution {
    int n;
    long[][] memo;
    public long maxSumTrionic(int[] nums) {
        n = nums.length;
        memo = new long[n+1][4];
        for(long[] a : memo){
            Arrays.fill(a,Long.MIN_VALUE);
        }
        return solve(0,0, nums); //solve(i, trend=0)
    }

    private long solve(int idx, int trend, int[] nums){
        //base case
        if(idx==n){
            if(trend==3){
                return 0;
            }else {
                return Long.MIN_VALUE/2;
            }
        }

        if(memo[idx][trend] != Long.MIN_VALUE) return memo[idx][trend];

        long take = Long.MIN_VALUE/2;
        long skip = Long.MIN_VALUE/2;

        if(trend==0){
            skip = solve(idx+1, trend, nums);
        }

        if(trend==3){
            take = nums[idx];//finish the sub-array here.
        }

        if(idx+1 < n){
            int curr = nums[idx], next = nums[idx+1];
            if(trend==0 && curr<next){
                take = Math.max(take, curr + solve(idx+1,1, nums));
            }else if(trend==1){
                if(curr < next){
                    take = Math.max(take, curr + solve(idx+1, 1, nums));
                }else if(curr > next){
                    take = Math.max(take, curr + solve(idx+1, 2, nums));
                }
            }else if(trend==2){
                if(curr > next){
                    take = Math.max(take, curr + solve(idx+1, 2, nums));
                }else if(curr < next){
                    take = Math.max(take, curr + solve(idx+1, 3, nums));
                }
            }else if(trend==3 && next > curr){
                take = Math.max(take, curr + solve(idx+1, 3, nums));
            }
        }

        return memo[idx][trend]=Math.max(skip,take);
    }
}