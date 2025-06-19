class Solution {
    private Set<Character> numbers = new HashSet<>();
    private Set<Character> alphabets = new HashSet<>();
    public boolean isPalindrome(String s) {

        for(char i = '0';i<='9';i++){
            numbers.add(i);
        }

        for(char i = 'a';i<='z';i++){
            alphabets.add(i);
        }

        for(char i = 'A';i<='Z';i++){
            alphabets.add(i);
        }

        // System.out.println(numbers);
        // System.out.println(alphabets);

        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0,right=n-1;

        while(left<=right){
            while(left < n && isValid(arr[left])){
                left++; 
            }

            while(right>=0 && isValid(arr[right])){
                right--;
            }

            if(left < n && arr[left] >= 'A' && arr[left] <= 'Z'){
                arr[left] += 32;
            }

            if(right >= 0 && arr[right] >= 'A' && arr[right] <= 'Z'){
                arr[right] += 32;
            }


            if(left < n && right >= 0 && arr[left]!=arr[right]){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isValid(char c){
        return !(alphabets.contains(c) || numbers.contains(c));
    }
}