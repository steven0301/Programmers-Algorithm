import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<people.length ;i++){
            list.add(people[i]);
        }
        
        Collections.sort(list);
        while(!list.isEmpty()){
            if(list.size() == 1){
                answer++;
                break;
            }
            int max = Collections.max(list);
            int min = Collections.min(list);
            if(max + min <= limit){
                list.remove(list.size()-1);
                list.remove(0);
                answer++;
            }else {
                list.remove(list.size()-1);
                answer++;
            }
        }
        
        return answer;
    }
}