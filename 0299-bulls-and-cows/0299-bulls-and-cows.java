class Solution {
    public String getHint(String secret, String guess) {
        int[] secretArr = new int[10];
        int[] guessArr = new int[10];
        int A=0,B=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                A++;
            }else{
                secretArr[secret.charAt(i)-'0']++;
                guessArr[guess.charAt(i)-'0']++;
            }
        }

        for(int i=0;i<10;i++){
            B+=Math.min(secretArr[i],guessArr[i]);
        }
        String ans = A+"A"+B+"B";
        return ans;
    }
}