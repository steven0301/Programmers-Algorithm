import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String result = "";

        List<String> list = new ArrayList<>();
        for(int e : numbers){
            list.add(String.valueOf(e));
        }

        // compareTo 함수를 사용해서 역순으로 더해지도록 한다.
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return -(s1+s2).compareTo(s2+s1);
            }
        };

        Collections.sort(list, comparator);
        
        // 0이 중복될 경우도 생각해 봐야한다.
        // 000... 일 경우에는 0이 리턴되어야 한다.
        if(list.get(0).equals("0")){
            return "0";
        }
        
        // result += str 보다 속도 측면에서 훨씬 더 빠르다.
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        
        result = sb.toString();
        return result;
    }
}