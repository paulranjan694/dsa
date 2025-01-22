class Solution {
    public String nextPalindrome(String num) {
        int n = num.length();

        if (n == 1) {
            return "";
        }

        int halfLength = n / 2;
        List<Character> leftHalf = new ArrayList<>();
        for (int i = 0; i < halfLength; i++) {
            leftHalf.add(num.charAt(i));
        }

        if (!findNextPermutation(leftHalf)) {
            return "";
        }

        StringBuilder nextPalindrome = new StringBuilder();
        for (char c : leftHalf) {
            nextPalindrome.append(c);
        }

        if (n % 2 == 0) {
            nextPalindrome.append(new StringBuilder(nextPalindrome).reverse());
        } else {
            nextPalindrome.append(num.charAt(halfLength));
            nextPalindrome.append(new StringBuilder(nextPalindrome.substring(0, halfLength)).reverse());
        }

        if (nextPalindrome.toString().compareTo(num) > 0) {
            return nextPalindrome.toString();
        }
        return "";
    }

    private boolean findNextPermutation(List<Character> digits){
        
        int i = digits.size() - 2;
        while (i >= 0 && digits.get(i) >= digits.get(i + 1)) {
            i--;
        }

        if(i==-1){
            return false;
        }

        int j = digits.size() - 1;
        while (digits.get(j) <= digits.get(i)) {
            j--;
        }

        Collections.swap(digits, i, j);
        Collections.reverse(digits.subList(i + 1, digits.size()));
        return true;
    }
}