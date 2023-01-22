package Mini_Reports;

import java.util.Scanner;

/**
 * @author 이성민(rjqnrdl1127)
 */
public class MiniReport08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        int income = scanner.nextInt();

        tax(income);
        System.out.print("[누진공제 계산에 의한 세금]:\t\t" + progressiveDeduction(income));
    }

    private static void tax(int income) {
        int totalTax = 0;
        int limit;
        int[] maxTax = {12000000, 34000000, 42000000, 62000000, 150000000, 200000000, 500000000};
        double[] tariff = {0.06, 0.15, 0.24, 0.35, 0.38, 0.4, 0.42, 0.45};
        String format = " %9d * %2d%% =\t %9d\n";

        if (income / 1000000 <= 12) {
            limit = 0;
        } else if (12 < income / 1000000 && income / 1000000 <= 46) {
            limit = 1;
        } else if (46 < income / 1000000 && income / 1000000 <= 88) {
            limit = 2;
        } else if (88 < income / 1000000 && income / 1000000 <= 150) {
            limit = 3;
        } else if (150 < income / 1000000 && income / 1000000 <= 300) {
            limit = 4;
        } else if (300 < income / 1000000 && income / 1000000 <= 500) {
            limit = 5;
        } else if (500 < income / 1000000 && income / 1000000 <= 1000) {
            limit = 6;
        } else {
            limit = 7;
        }

        if (limit == 0){
            totalTax += (int) (income * tariff[0]);
            System.out.printf(format + "\n", income, (int) (tariff[0] * 100), (int) (income * tariff[0]));
        } else {
            int i = 0;
            while (true) {
                if (i == limit) {
                    totalTax += income * tariff[i];
                    System.out.printf(format + "\n", income, (int) (tariff[i] * 100), (int) (income * tariff[i]));
                    break;
                } else {
                    income -= maxTax[i];
                    totalTax += (int) (maxTax[i] * tariff[i]);
                    System.out.printf(format, maxTax[i], (int) (tariff[i] * 100), (int) (maxTax[i] * tariff[i]));
                }

                i++;
            }
        }

        System.out.printf("[세율에 의한 세금]:\t\t\t\t%d\n", totalTax);
    }

    static int progressiveDeduction(int income) {
        int tax;

        if (income / 1000000 <= 12) {
            return 0;
        } else if (12 < income / 1000000 && income / 1000000 <= 46) {
            tax = (income / 100 * 15) - 1080000;
        } else if (46 < income / 1000000 && income / 1000000 <= 88) {
            tax = (income / 100 * 24) - 5220000;
        } else if (88 < income / 1000000 && income / 1000000 <= 150) {
            tax = (income / 100 * 35) - 14900000;
        } else if (150 < income / 1000000 && income / 1000000 <= 300) {
            tax = (income / 100 * 38) - 19400000;
        } else if (300 < income / 1000000 && income / 1000000 <= 500) {
            tax = (income / 100 * 40) - 25400000;
        } else if (500 < income / 1000000 && income / 1000000 <= 1000) {
            tax = (income / 100 * 42) - 35400000;
        } else {
            tax = (income / 100 * 45) - 65400000;
        }

        return tax;
    }
}