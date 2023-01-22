package Algorithms.CodingTest01;

// 정수 n보다 작은 소수의 개수 반환하기
// 정확성 100% 효율성 100%

public class Solution01 {

    public int solution(int n) {
        int answer = 0;

        boolean[] prime = new boolean[n + 1];

        /*
        소수가 아닌 index = true
        소수인 index = false
         */

        // n이 1일 경우 0 반환
        if (n < 2) {
            return 0;
        }

        prime[0] = prime[1] = true;

        // 제곱근 함수 : Math.sqrt()
        for (int i = 2; i < Math.sqrt(n); i++) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if (prime[i]) continue;

            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

        for (int i = 0; i < prime.length - 1; i++) { // n은 제외
            if (!prime[i]) { // 소수(faluse)일 경우 1씩 증가
                answer++;
            }
        }

        return answer;
    }
}
