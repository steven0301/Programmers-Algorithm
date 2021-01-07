import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<scoville.length ;i++){
            list.add(scoville[i]);
        }
        
        int cnt = 0;
        while(list.size() > 1){
            Collections.sort(list);
            int first = list.get(0);
            System.out.println(String.format("first : %d", first));
            if(first >= K) return cnt;
            
            int second = list.get(1);
            System.out.println("second : "+ second);
            list.remove(0);
            list.remove(1);
            
            for(int e : list){
                System.out.println(String.format("e : %d", e));
            }
            
            list.add(first + second*2);
            cnt++;
        }
        
        int last = list.get(0);
        if(last < K) return -1;
        else answer = cnt;
        
        return answer;
    }
}