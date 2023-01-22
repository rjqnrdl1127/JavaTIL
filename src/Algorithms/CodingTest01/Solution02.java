package Algorithms.CodingTest01;

import java.util.Arrays;
import java.util.LinkedHashSet;

// 응모자 중 당첨자 4명 뽑는 경우의 수 구하기
// 중복 응모는 제외
// 정확도 100% 효율성 20%(시간 복잡도가 높은 것 같음)

public class Solution02 {

    public int solution(String[] names) {
        int answer;

        if (names.length < 4) {
            return 0;
        }

        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(names)); // 중복되는 이름 제거

        answer = fatorial(set.size()) / (fatorial(set.size() - 4) * fatorial(4)); // n개의 이름 중 4개 뽑는 경우의 수(조합)

        return answer;
    }

    private int fatorial(int n) {

        if (n == 1) return 1;
        return n * fatorial(n - 1);
    }
}
