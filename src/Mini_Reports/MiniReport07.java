package Mini_Reports;

import java.util.*;

/**
 * @author 이성민(rjqnrdl1127)
 */
public class MiniReport07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t; // 로또 개수
        HashMap<Character, Integer[]> cases = new HashMap<>(); // 각 로또 알파벳과 로또 숫자 배열
        Integer[] result = lotto(); // 로또 발표 결과

        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            Integer[] arr = lotto();

            System.out.printf("%c\t%02d,%02d,%02d,%02d,%02d,%02d\n",(char) (i + 64), arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);

            cases.put((char) (i + 64), arr);
        }
        System.out.println();

        System.out.println("[로또 발표]");
        System.out.printf("\t%02d,%02d,%02d,%02d,%02d,%02d\n\n", result[0], result[1], result[2], result[3], result[4], result[5]);

        System.out.println("[내 로또 결과]");
        for (int i = 1; i <= t; i++) {
            Integer[] arr = cases.get((char) (i + 64)); // 알파벳으로 배열 갖고오기
            int count = isSameCount(arr, result); // 로또 숫자 일치 개수

            System.out.printf("%c\t%02d,%02d,%02d,%02d,%02d,%02d => %d개 일치\n", (char) (i + 64), arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], count);
        }
    }

    static Integer[] lotto() { // 로또 숫자 생성 메서드
        HashSet<Integer> set = new HashSet<>();
        Integer[] arr;

        while(set.size() < 6) {
            int n = (int) (Math.random() * 45) + 1;
            set.add(n);
        }
        arr = set.toArray(new Integer[0]);

        return  arr;
    }

    static int isSameCount(Integer[] arr1, Integer[] arr2) { // 로또 숫자 비교 메서드
        int count = 0;

        for (int n1 : arr1) {
            for (int n2 : arr2) {
                if (n1 == n2) {
                    count++;
                }
            }
        }
        return count;
    }
}
