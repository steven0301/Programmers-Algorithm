import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            if(map.get(clothes[i][1]) == null){
                map.put(clothes[i][1], 1);
            }else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }
        
        answer = 1;
        for(String key : map.keySet()){
            // 입지 않는 경우도 포함 
            // 예시) 모자가 3개라면 안 입는 경우까지 포함하여 4개가 된다.
            answer *= (map.get(key) + 1);
        }
        
        // 모두 입지 않았을 경우의 수는 제외한다.
        return answer-1;
    }
}