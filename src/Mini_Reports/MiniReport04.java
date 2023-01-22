package Mini_Reports;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 이성민(rjqnrdl1127)
 */
public class MiniReport04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month, day;
        int examNumber = new Random().nextInt(999999);



        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        year = scanner.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        month = scanner.nextInt();
        System.out.print("출생일을 입력해 주세요.(dd):");
        day = scanner.nextInt();
        System.out.print("성별을 입력해 주세요.(m/f):");

        switch (scanner.next()) {
            case "m":
                if (year < 2000) {
                    System.out.printf("%02d%02d%02d-1%d", year - (year / 100) * 100, month, day, examNumber);
                } else {
                    System.out.printf("%02d%02d%02d-3%d", year - (year / 100) * 100, month, day, examNumber);
                }break;
            case "f":
                if (year < 2000) {
                    System.out.printf("%02d%02d%02d-2%d", year - (year / 100) * 100, month, day, examNumber);
                } else {
                    System.out.printf("%02d%02d%02d-4%d", year - (year / 100) * 100, month, day, examNumber);
                }
                break;
        }
    }
}