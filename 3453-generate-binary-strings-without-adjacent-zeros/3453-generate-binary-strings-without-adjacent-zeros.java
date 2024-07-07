class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        utils(n,ans,sb);
        return ans;
    }

    public void utils(int n,List<String> ans, StringBuilder sb){
        if (sb.length() == n) {
            ans.add(sb.toString());
            return;
        }

        sb.append("1");
        utils(n, ans, sb);
        sb.deleteCharAt(sb.length() - 1);

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '0') {
            sb.append("0");
            utils(n, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0) {
            sb.append("0");
            utils(n, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}