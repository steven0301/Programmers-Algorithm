import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();        

        for(int i=0; i<commands.length ;i++){
            int start = commands[i][0];
            int end   = commands[i][1];
            int k     = commands[i][2];
            int[] temp = Arrays.copyOfRange(array,start-1,end);
            Arrays.sort(temp);
            answerList.add(temp[k-1]);
        }
        
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}