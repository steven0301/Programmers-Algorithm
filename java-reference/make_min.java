import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0; i<A.length ;i++){
            list1.add(A[i]);
            list2.add(B[i]);
        }
        
        while(!list1.isEmpty()){
            int min1 = Collections.min(list1);
            int min2 = Collections.min(list2);
            int max1 = Collections.max(list1);
            int max2 = Collections.max(list2);
            
            if(max1 > max2){
                answer += (max1 * min2);
                list1.remove((Integer) max1);
                list2.remove((Integer) min2);
            }else if(max1 < max2){
                answer += (max2 * min1);
                list1.remove((Integer) min1);
                list2.remove((Integer) max2);
            }else {
                if(min1 < min2){
                    answer += (min1 * max2);
                    list1.remove((Integer) min1);
                    list2.remove((Integer) max2);
                }else {
                    answer += (min2 * max1);
                    list1.remove((Integer) max1);
                    list2.remove((Integer) min2);
                }
            }
        }

        return answer;
    }
}