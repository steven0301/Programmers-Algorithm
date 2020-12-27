import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        
        // yellow의 가로 및 세로 가짓수를 구하기 위함
        List<Integer> yellowList = new ArrayList<>();
        for(int i=1; i<=yellow ;i++){
            if(yellow%i == 0) yellowList.add(yellow/i);
        }
                
        for(int yellow_y : yellowList){
            int yellow_x = yellow/yellow_y;
            if(yellow_x >= yellow_y && 
               (yellow_x + 2) * (yellow_y + 2) == brown + yellow){
                answer[0] = yellow_x + 2;
                answer[1] = yellow_y + 2;
                break;
            }
        }       
        
        return answer;
    }
}