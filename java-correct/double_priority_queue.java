import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    // List<String> 에서 문자열 숫자 순서대로 정렬해보려 했지만 실패함
    public int[] solution(String[] operations) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<operations.length ;i++){
            String op = operations[i].split(" ")[0];
            int num = Integer.parseInt(operations[i].split(" ")[1]);
            if(op.equals("I")) list.add(num);
            else if(op.equals("D") && !list.isEmpty()){
                if(num < 0){
                    int min = Collections.min(list);
                    // 중요 : remove by object
                    list.remove(Integer.valueOf(min));
                }else {
                    int max = Collections.max(list);
                    list.remove(Integer.valueOf(max));
                }
            }
        }
        
        if(list.isEmpty()){
            answer = new int[2];
            answer[0] = 0;
            answer[1] = 0;
        }else {
            answer = new int[2];
            answer[0] = Collections.max(list);
            answer[1] = Collections.min(list);
        }
        
        return answer;
    }
}