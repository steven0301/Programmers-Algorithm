import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<prices.length-1 ;i++){
            int sum = 0;
            for(int j=i+1; j<prices.length ;j++){
                int a = prices[i];
                int b = prices[j];
                if(a <= b) ++sum;
                if(a > b){
                  ++sum; break;  
                } 
            }
            list.add(sum);
        }
        list.add(0);
        
        answer = new int[list.size()];
        for(int i=0; i<list.size() ;i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}