import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        int answer = -1;

        // 6 5 3 1 0 : 3
        // 21 20 19  : 3
        // 0 0 0 0 0 : 0

        // comparator를 사용하기 위해 : int[] -> Integer[]
        Integer[] arr = new Integer[citations.length];
        for(int i=0; i<citations.length ;i++){
            arr[i] = citations[i];
        }

        // 내림차순으로 Integer 배열 정렬
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return -Integer.compare(a, b);
            }
        });

        int cnt = 0;
        for(int i=0; i<arr.length ;i++){
            cnt = i+1;
            if(arr[i] >= cnt) {
                answer = cnt;
            }else {
                break;
            }
        }

        if(arr[0] == 0) return 0;
        if(answer == -1) return arr.length;
        return answer;
    }
}