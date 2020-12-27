import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<Test> list = new ArrayList<>();
        for(int i=0; i<numbers.length ;i++){
            list.add(new Test(numbers[i]));
        }
        
        Collections.sort(list);
                
        for(Test t : list){
            answer += String.valueOf(t.getNumber());
        }
        
        return answer;
    }
}

class Test implements Comparable<Test>{
    private int number;
    private int num;
    
    Test(int number){
        this.number = number;
        while(number/10 != 0){
            number %= 10;
        }
        this.num = number;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    @Override
    public int compareTo(Test t){
        if(this.num > t.num) {
            return -1;
        }else if (this.num == t.num){
            if(this.number > t.number ){
                return -1;
            }else if(this.number == t.number){
                return 0;
            }else {
                return 1;
            }
        }else {
            return 1;
        }
    }

}
