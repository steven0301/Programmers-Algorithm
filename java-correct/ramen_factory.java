import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ramen_factory {
    public static void main(String[] args){
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        System.out.println(String.format("answer : %d", solution(stock, dates, supplies, k)));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k){
        int answer = 0;
        List<Load> list = new ArrayList<>();
        for(int i=0; i<dates.length ;i++){
            list.add(new Load(dates[i], supplies[i]));
        }
        Collections.sort(list);

        // 중요 : stock을 하루에 1씩 사용하고, k일 까지 stock이 남이있다.
        // -> 재고량이 stock >= k 이면 된다는 의미
        while(stock < k){
            for(int i=0; i<list.size() ;i++){
                if(stock >= list.get(i).date){
                    stock += list.get(i).supply;
                    list.remove(i);
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}

class Load implements Comparable<Load>{

    public int date;
    public int supply;

    Load(int date, int supply){
        this.date = date;
        this.supply = supply;
    }

    @Override
    public int compareTo(Load l){
        if(this.supply > l.supply) return -1;
        else if(this.supply == l.supply) return (this.supply < l.supply)? -1:1;
        else return 1;
    }
}