import java.time.LocalDate;

public class year_2016_date {
    public static void main(String[] args){
        int year = 2016;
        int month = 5;
        int day = 24;
        LocalDate date = LocalDate.of(2016, month, day);
        System.out.println(String.format("day of the week : %s", date.getDayOfWeek().toString().substring(0, 3)));
    }
}
