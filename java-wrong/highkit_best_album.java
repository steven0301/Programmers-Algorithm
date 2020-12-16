import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        List<String> aList = new ArrayList<>();
        for(int i=0; i<genres.length ;i++){
            aList.add(genres[i] + plays[i]);
        }
        Collections.sort(aList, Comparator.reverseOrder());
        
        for(String str : aList){
            System.out.println(String.format("str : %s", str));
        }
        
        
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length ;i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        Map<String, Integer> sortedMap = map.entrySet().stream()
                        .sorted(Entry.comparingByValue(Comparator.reverseOrder())) // 내림차순
                         .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
               
        
        List<Integer> tempList = new ArrayList<>();
        
        for(String key : sortedMap.keySet()){
            int cnt = 0;
            for(int i=0; i<aList.size() ;i++){
                if((aList.get(i)).startsWith(key)){
                    cnt++;
                    tempList.add(i);
                }
                if(cnt == 2) break;
            }
        }
        
        answer = new int[tempList.size()];
        for(int i=0; i<answer.length ;i++){
            answer[i] = tempList.get(i);
        }
        
        return answer;
    }
}