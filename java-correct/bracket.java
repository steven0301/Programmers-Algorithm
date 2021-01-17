import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length() ;i++){
            // '('일 때 추가하고, ')'일 때 하나씩 뺀다.
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));    
            }else {
                if(stack.isEmpty()){
                    return answer;
                }else{
                    stack.pop();
                }
            }
        }
        // stack 추가/삭제 작업이 끝나도 남아있으면 불가능한 경우로 판단한다.
        answer = stack.isEmpty()? true:false;
        return answer;
    }
}