class Solution {
    public int largestInteger(int num) {
         List<Integer> digits = new ArrayList<>();
      
      while(num > 0){
        int rem = num%10;
        digits.add(rem);
        num = num / 10;
      }
      
      Collections.reverse(digits);
      Queue<Integer> even = new PriorityQueue<>((a,b) -> b-a);
      Queue<Integer> odd = new PriorityQueue<>((a,b) -> b-a);
      
      for(int e:digits){
        if(e % 2 == 0){
          even.offer(e);
        }else{
          odd.offer(e);
        }
      }
      
      StringBuilder sb = new StringBuilder();
      for(int e : digits){
        if(e%2==0){
          sb.append(even.poll());
        }else{
          sb.append(odd.poll());
        }
      }
      
      return Integer.parseInt(sb.toString());
    }
}