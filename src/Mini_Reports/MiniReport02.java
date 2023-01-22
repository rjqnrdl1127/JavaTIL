package Mini_Reports;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author 이성민(rjqnrdl1127)
 */

public class MiniReport02 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n, cashback;  // 금액, 캐시백 변수

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");

        n = scanner.nextInt();  // 금액 입력 받기
        cashback = cashBack(n);  // 캐시백 구하는 함수 사용

        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", n, cashback);
    }

    public static int cashBack(int n) {

        if (n * 0.1 >= 300) {
            return 300;
        } else {
            return (int) ((int) n * 0.1 - (n * 0.1 % 100));
        }
    }
}
