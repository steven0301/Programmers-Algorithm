import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        // map에 장르별 총 play합을 저장
        // ex) map : ("classic", 1450), ("pop", 3100)
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        // Song 객체 list 생성
        // * 주의1 : 여기서 count<2 제한을 통해서 list에 입력을 제한하면 안된다.
        List<Song> list = new ArrayList<>();
        for(String key : map.keySet()){
            for(int i=0; i<genres.length ;i++){
                if(key.equals(genres[i])){
                    list.add(new Song(i, genres[i], map.get(key), plays[i]));
                }
            }
        }

        // list 정렬 : 가장 많이 플레이된 장르, 개별 plays 순서로 정렬
        Collections.sort(list);

        // list는 각 장르별 2개 제한이 없으므로, 이곳에서 2개까지 제한하여 answerList에 담는다.
        int cnt = 0;
        List<Integer> answerList = new ArrayList<>();

        // * 주의2: map을 value기준 내림차순으로 정렬
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for(String key : keyList){
            for(int i=0; i<list.size() ;i++){
                if(key.equals(list.get(i).getGenre()) && cnt < 2){
                    answerList.add(list.get(i).getIndex());
                    cnt++;
                }
            }
            cnt = 0;
        }

        // list -> int[] 변환
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

class Song implements Comparable<Song>{
    private int index;
    private String genre;
    private int genreCnt;
    private int plays;

    Song(int index, String genre, int genreCnt, int plays){
        this.index = index;
        this.genre = genre;
        this.genreCnt = genreCnt;
        this.plays = plays;
    }

    public int getIndex(){
        return this.index;
    }

    public String getGenre(){
        return this.genre;
    }

    @Override
    public int compareTo(Song s){
        if(this.genreCnt > s.genreCnt) return -1;
        else if(this.genreCnt == s.genreCnt){
            if(this.plays > s.plays) return -1;
            else if(this.plays == s.plays) return 0;
            else return 1;
        }
        else return 1;
    }
}