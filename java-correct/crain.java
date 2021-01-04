import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;       
        Stack<Integer> stack = new Stack<>();

        /* To do */
        // 향후 for(int move : moves) 를 사용하고
        // 3중 for -> 2중 for로 변경해본다.
        for(int k=0; k<moves.length; k++){
            loop: for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    if((board[i][j] != 0) && (j == moves[k]-1)){

                        if(stack.isEmpty()) stack.push(board[i][j]);

                        else{
                            if(stack.peek() == board[i][j]) {
                                stack.pop();
                                answer += 2;
                            }else {
                                stack.push(board[i][j]);
                            }
                        }
                        board[i][j] = 0;
                        break loop;
                    }
                }
            }            
        }
        return answer;
    }
}