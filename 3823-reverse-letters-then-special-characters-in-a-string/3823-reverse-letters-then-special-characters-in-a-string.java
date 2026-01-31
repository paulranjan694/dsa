class Solution {
    public String reverseByType(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int leftCh=0,rightCh=n-1, leftSy=0,rightSy=n-1;
        Set<Character> speCharacters = new HashSet<>();

        String spechar = "!@#$%^&*()";
        for(char c : spechar.toCharArray()){
            speCharacters.add(c);
        }

        while(leftCh<rightCh){
            char left = arr[leftCh], right = arr[rightCh];
            if(left >= 'a' && left <= 'z' && right >= 'a' && right <= 'z'){
                arr[leftCh] = right;
                arr[rightCh] = left;
                leftCh++;
                rightCh--;
            }else if(left >= 'a' && left <= 'z'){
                rightCh--;
            }else{
                leftCh++;
            }
        }

        while(leftSy<rightSy){
            char left = arr[leftSy], right = arr[rightSy];
            if (speCharacters.contains(left) && speCharacters.contains(right)) {
                arr[leftSy] = right;
                arr[rightSy] = left;
                leftSy++;
                rightSy--;
            }else if(speCharacters.contains(left)){
                rightSy--;
            }else{
                leftSy++;
            }
        }

        return new String(arr);
    }
}