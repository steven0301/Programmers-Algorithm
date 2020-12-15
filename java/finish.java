import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
                
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant){
            if(map.get(p) == null){
                map.put(p, 1);
            }else {
                map.put(p, map.get(p)+1);
            }
        }
        
        for(String c : completion){
            if(map.get(c) != null){
                map.put(c, map.get(c)-1);
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == 1) answer = key;
        }
        
        return answer;
    }
}