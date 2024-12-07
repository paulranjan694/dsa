class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] hash=new int[26];
        int n1=s1.length(), n2=s2.length();
        if(n1>n2) return false;
        for(int i=0;i<n1;i++){
            char ch = s1.charAt(i);
            hash[ch-'a']++;
        }
        int[] temp = Arrays.copyOf(hash,26);
        int l=0,r=0;
        while(r<n2){
            char c = s2.charAt(r);
            temp[c-'a']--;
            if((r-l+1) > n1){
                char t = s2.charAt(l);
                temp[t-'a']++;
                l++;
            }

            if((r-l+1) == n1){
                int present=1;
                for(int i=0;i<26;i++){
                    if(temp[i]!=0){
                        present=0;
                        break;
                    }
                }
                if(present==1) return true;
            }
            r++;
        }
        return false;
    }
}