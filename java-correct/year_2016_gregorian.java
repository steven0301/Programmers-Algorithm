import java.util.GregorianCalendar;

class Solution {
    public String solution(int a, int b) {
        String answer = "";

        GregorianCalendar cal = new GregorianCalendar();
        cal.set(GregorianCalendar.YEAR, 2016);
        cal.set(GregorianCalendar.MONTH, a-1);
        cal.set(GregorianCalendar.DATE, b);

        switch(cal.get(GregorianCalendar.DAY_OF_WEEK)){
            case 1: answer = "SUN"; break;
            case 2: answer = "MON"; break;
            case 3: answer = "TUE"; break;
            case 4: answer = "WED"; break;
            case 5: answer = "THU"; break;
            case 6: answer = "FRI"; break;
            case 7: answer = "SAT"; break;
        }
        return answer;
    }
}