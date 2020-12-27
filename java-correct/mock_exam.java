import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};        
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int cnt1 = 0;  int cnt2 = 0;  int cnt3 = 0;
        
        // 각 각 정답인 횟수 카운트
        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr1[i%(arr1.length)]) cnt1++;
            if(answers[i] == arr2[i%(arr2.length)]) cnt2++;
            if(answers[i] == arr3[i%(arr3.length)]) cnt3++;        
        }
        int max = Math.max(cnt1, (Math.max(cnt2, cnt3)));
        
        // 최댓값과 같으면 답안 list에 넣는다.
        List<Integer> answerList = new ArrayList<>();
        if(cnt1 == max)  answerList.add(1);
        if(cnt2 == max)  answerList.add(2);
        if(cnt3 == max)  answerList.add(3);
        
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size() ;i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}