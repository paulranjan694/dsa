class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftParenthesis = new Stack<>();
        Stack<Integer> star = new Stack<>();
       
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(leftParenthesis.empty() && star.empty()) return false;
                if(!leftParenthesis.empty()){
                    leftParenthesis.pop();
                }else{
                    star.pop();
                }
            }else if(c == '('){
                leftParenthesis.push(i);
            }else{
                star.push(i);
            }
        }

        while(!leftParenthesis.empty() && !star.empty()){
            if(leftParenthesis.pop() > star.pop()){
                return false;
            }
        }
        
        return leftParenthesis.empty();

    }
}