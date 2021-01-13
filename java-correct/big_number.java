import java.util.Stack;

class Solution {
    public String solution(String number, int k) {        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<number.length() ;i++){
            while(!stack.isEmpty() && k>0
                  && number.charAt(i) > stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        // stack의 상위 부분에는 가장 작은수부터 위치해 있으며,
        // k를 계속 제거해서 0이 되어야 원하는 값이 나온다.
        // 예시) number = "77777", k=2 -> answer = "77"
        while(!stack.empty()){
            if(k != 0){
                stack.pop();
                k--;
            }else{
                sb.append(stack.pop());    
            }
        }
        return sb.reverse().toString();
    }
}