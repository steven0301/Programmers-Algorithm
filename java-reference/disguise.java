import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        
        List<Integer> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(map.get(key));            
        }
        
        // 이러면 2가지 의상에 대한 경우의 수만 구할 수 있다.
        // 늘어나는 의상 가짓수에 대한 대처 불가.
        for(int i=0; i<list.size() ;i++){
            for(int j=0; j<list.size() ;j++){
                if(i != j) answer += (list.get(i) * list.get(j));
            }
        }
        
        return answer;
    }
}