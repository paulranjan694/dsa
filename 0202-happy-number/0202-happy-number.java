class Solution {
    public boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>();
      
        int slow = n, fast = n;
        int sq = n;
        for(int i = 0; i< 2;i++){
            sq = findSquare(sq);
            map.put(n,sq);
            fast=sq;
        }
        
        while(fast != slow && fast != 1){
            if(map.containsKey(slow))
                slow=map.get(slow);
            else{
                sq = findSquare(slow);
                map.put(slow,sq);
                slow = sq;
            }
            
            for(int i=0;i<2;i++){
                if(map.containsKey(fast)){
                    fast = map.get(fast);
                }else{
                    sq = findSquare(fast);
                    map.put(fast,sq);
                    fast=sq;
                }
            }
            
            if(fast==slow) return false;
        }
        return fast == 1;
    }
     private static int findSquare(int n){
        int sum=0;
        while(n!=0){
          int rem = n % 10;
          sum += rem*rem;
          n /= 10;
        }
        return sum;
    }
}