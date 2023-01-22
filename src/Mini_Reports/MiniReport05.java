package Mini_Reports;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author 이성민(rjqnrdl1127)
 */
public class MiniReport05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month, countDays, dayOfWeek; // 연도, 월, 일수, 시작 요일
        LocalDate date1, date2 ; // 비교할 날짜 변수
        Calendar cal = Calendar.getInstance();

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        year = scanner.nextInt();

        System.out.print("달력의 월을 입력해 주세요.(mm):");
        month = scanner.nextInt();

        date1 = LocalDate.of(year, month, 1); // month의 1일
        date2 = LocalDate.of(year, month + 1, 1); // 다음 달의 1일
        countDays = (int) ChronoUnit.DAYS.between(date1, date2); // 두 날짜간의 차이(일수)

        cal.set(year, month - 1, 1);
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 1일의 x요일

        System.out.printf("[%d년 %02d월]\n", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        switch(dayOfWeek){ // 시작 요일에 따라 빈 공간 출력
            case 7:System.out.print(" \t"); // 토
            case 6: System.out.print(" \t"); // 금
            case 5: System.out.print(" \t"); // 목
            case 4: System.out.print(" \t"); // 수
            case 3: System.out.print(" \t"); // 화
            case 2: System.out.print(" \t"); // 월
        }

        int countDay = dayOfWeek; // 시작 요일 정하기

        for(int i = 1;i <= countDays; i++){ // 일 출력
            System.out.printf("%02d\t", i);

            if(countDay%7==0){
                System.out.println(); // 토요일마다 줄바꿈
            }

            countDay++;
        }
    }
}
