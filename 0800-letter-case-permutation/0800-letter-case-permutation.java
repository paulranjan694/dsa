class Solution {
    private static Set<String> set = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(s,result,0,sb);
        return result;
    }

    private void solve(String s, List<String> result, int curIndex, StringBuilder sb){
        if(curIndex==s.length()){
            result.add(sb.toString());
            return;
        }
        char ch = s.charAt(curIndex);
        char convertedch = ch;
        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){
            if(ch >= 'A' && ch <= 'Z'){
                convertedch = (char)(convertedch | 32);
            }else{
                convertedch = (char)(convertedch & ~32);
            }

            sb.append(ch);
            solve(s,result,curIndex+1,sb);
            sb.deleteCharAt(sb.length()-1);

            sb.append(convertedch);
            solve(s,result,curIndex+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(ch);
            solve(s,result,curIndex+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}