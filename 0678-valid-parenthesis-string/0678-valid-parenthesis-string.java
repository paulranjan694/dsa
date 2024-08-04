class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> brac = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch=='(') brac.push(i);
            else if(ch == ')'){
                if(!brac.empty()) brac.pop();
                else if(!star.empty()) star.pop();
                else return false;
            }else{
                star.push(i);
            }
        }

        while(!brac.empty() && !star.empty()){
            if(brac.peek() > star.peek()) return false;
            brac.pop();
            star.pop();
        }
        return brac.empty();
    }
}