class Solution {
    public String minWindow(String s1, String s2) {
        int minLength=Integer.MAX_VALUE;
        String result="";
        int indexS1=0,indexS2=0,start=0,end=0,lenS1 = s1.length(), lenS2 = s2.length();
       
        while(indexS1 < lenS1){
            if(s1.charAt(indexS1) == s2.charAt(indexS2)){
                indexS2+=1;
                if(indexS2 == lenS2){
                    start = indexS1;
                    end = indexS1;

                    indexS2 -= 1;
                    while(indexS2 >= 0){
                        if(s1.charAt(start) == s2.charAt(indexS2)){
                            indexS2 -= 1;
                        }
                        start -= 1;
                    }
                    start += 1;

                    if((end -start +1) < minLength){
                        minLength = (end -start +1);
                        result = s1.substring(start,end+1);
                    }
                    indexS1 = start;
                    indexS2=0;
                }
            }
            indexS1 += 1;
        }
        return result;

    }
}