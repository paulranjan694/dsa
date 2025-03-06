class Solution {
    public char findTheDifference(String s, String t) {
        int ans=0;
        int indexS = 0,indexT=0,lenS = s.length(), lenT = t.length();
        while(indexS < lenS && indexT < lenT){
            ans ^= s.charAt(indexS) ^ t.charAt(indexT);
            indexS++;
            indexT++;
        }

        while(indexS < lenS ){
            ans ^= s.charAt(indexS);
            indexS++;
        }

        while(indexT < lenT){
            ans ^= t.charAt(indexT);
            indexT++;
        }
        return (char)ans;

    }
}