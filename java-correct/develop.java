import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        // 완료까지의 작업일수 계산 (list)
        List<Double> list = new ArrayList<>();
        for(int i=0; i<progresses.length ;i++){
            double days = Math.ceil((double)(100 - progresses[i])/(double)speeds[i]);
            list.add(days);
        }
        
        // 대표값(std)을 정하고 큰 값이 나오면 대표값 교체 및 작업리스트(answerList)에 추가
        int cnt = 1;
        double std = list.get(0);
        List<Integer> answerList = new ArrayList<>();
        for(int i=1; i<list.size() ;i++){
            if(std >= list.get(i)){
                cnt++;
            }else{
                answerList.add(cnt);
                cnt = 1;
                std = list.get(i);
            }
            if(i == list.size()-1) answerList.add(cnt);
        }
        
        // list -> array 변환
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size() ;i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}