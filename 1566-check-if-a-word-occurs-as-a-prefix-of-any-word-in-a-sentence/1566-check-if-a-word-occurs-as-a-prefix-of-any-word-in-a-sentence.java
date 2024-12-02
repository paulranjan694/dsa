class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        char[] word = searchWord.toCharArray();
        for(int k=0;k<arr.length;k++){
            char[] ch = arr[k].toCharArray();
            int i=0,j=0;
            boolean found = true;
            if(word.length > ch.length) continue;
            while(i<word.length && j < ch.length){
                if(word[i] != ch[i]){
                    found=false;
                    break;
                }
                i++;j++;
            }
            if(found){
                return k+1;
            }
        }

        return -1;
    }
}