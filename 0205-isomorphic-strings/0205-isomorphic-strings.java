class Solution {
    // public boolean isIsomorphic(String s, String t) {
    //     if(s.length() != t.length()) return false;
    //     HashMap<Character,Character> mapS = new HashMap<>();
    //     HashMap<Character,Character> mapT = new HashMap<>();
    //     for(int i=0;i<s.length();i++){
    //         char sch = s.charAt(i);
    //         char tch = t.charAt(i);
    //         if(mapS.containsKey(sch)){
    //             if(mapS.get(sch) != tch){
    //                 return false;
    //             }
    //         }else{
    //             mapS.put(sch,tch);
    //         }

    //         if(mapT.containsKey(tch)){
    //             if(mapT.get(tch) != sch){
    //                 return false;
    //             }
    //         }else{
    //             mapT.put(tch,sch);
    //         }


    //     }
    //     return true;
    // }

    public boolean isIsomorphic(String s, String t) {
         if(s.length() != t.length()) return false;

        int[] arrS = new int[256];
        int[] arrT = new int[256];

        for(int i=0;i<s.length();i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(arrS[sch] != arrT[tch]){
                return false;
            }

            arrS[sch] = i+1;
            arrT[tch] = i+1;
 

        }
        return true;
    }
}