import java.util.ArrayList;
import java.util.Arrays;
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
        
        Map<Integer, String> map2 = new HashMap<>();
        for(int i=0; i<genres.length ;i++){
            map2.put(plays[i], genres[i]);
        }
        Object[] mapKey = map2.keySet().toArray();
        Arrays.sort(mapKey, Collections.reverseOrder());
        
        List<String> aList = new ArrayList<>();
        for(int i=0; i<genres.length ;i++){
            aList.add(genres[i] + plays[i]);
        }
        Collections.sort(aList, Comparator.reverseOrder());

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
            for(int key2 : map2.keySet()){
                if(key.equals(map2.get(key2))){
                    cnt++;
                    tempList.add(key2);
                }
                if(cnt == 2) break;
            }
            
        }
        
        List<Integer> bList = new ArrayList<>();
        for(int a : tempList){
            for(int i=0; i<plays.length ;i++){
                if(a == plays[i]){
                    bList.add(i);
                    break;
                }
            }
        }
        
        answer = new int[bList.size()];
        for(int i=0; i<answer.length ;i++){
            answer[i] = bList.get(i);
        }
        
        return answer;
    }
}