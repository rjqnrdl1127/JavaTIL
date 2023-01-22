package Mini_Reports;

import java.util.Scanner;

/**
 * @author 이성민(rjqnrdl1127)
 */

public class MiniReport03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age, time;  // 나이, 입장시간 변수
        String merit, welfare;


        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        age = scanner.nextInt();

        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        time = scanner.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        merit = scanner.next();

        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        welfare = scanner.next();

        System.out.println("입장료: " + result(age, time, merit, welfare));
    }

    public static int result(int age, int time, String merit, String welfare) {

        if (age < 3) {
            return 0;
        } else if ((age >= 3 && age < 13) || time > 17) {
            return 4000;
        }

        if (merit.equals("y") || welfare.equals("y")){
            return 8000;
        }


        return 10000;
    }
}
