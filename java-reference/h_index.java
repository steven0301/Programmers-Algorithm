import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 6 5 3 1 0
        // 6 5 4 3 2
        // 20 19 18 17
       
        // comparator를 사용하기 위해 : int[] -> Integer[]
        Integer[] arr = new Integer[citations.length];
        for(int i=0; i<citations.length ;i++){
            arr[i] = citations[i];
        }
        
        int len = arr.length;
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return -Integer.compare(a, b);
            }
        });

        int cnt = 0;
        for(int i=0; i<len ;i++){
            cnt = i+1;
            if(arr[i] >= cnt) {
                answer = cnt;
            }else {
                break;
            }
        }
        
        if(answer == 0) answer = arr.length;
        
        return answer;
    }
}