import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 캐시가 없을 경우에는 바로 return
        if(cacheSize == 0) return 5 * cities.length;
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();
            if(list.size() < cacheSize){
                // list에 city가 있는지 확인한다.
                if(list.contains(city)) answer += 1;
                else answer += 5;
                list.add(city);
            }else {
                if(list.contains(city)) {
                    answer += 1;
                    // city가 포함된 index를 찾아서 제거한다.
                    list.remove(list.indexOf(city));
                }else {
                    answer += 5;
                    list.remove(0);
                }
                list.add(city);
            }
        }
        return answer;
    }
}