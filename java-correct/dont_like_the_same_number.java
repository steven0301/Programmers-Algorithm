import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        // 배열 arr 원소는 9이하 자연수 이다.
        // 따라서 10이 나올 수 없으며, 다른 값이 나타날 때 list에 add한다.
        int temp = 10;
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(temp != arr[i]) {
                temp = arr[i];
                answerList.add(arr[i]);
            }
        }
        
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}