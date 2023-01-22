package Mini_Reports;

import java.util.Random;

/**
 * @author 이성민(rjqnrdl1127)
 */
public class MiniReport06 {

    public static void main(String[] args) {
        String[][] candidates = {{"1", "이재명"}, {"2", "윤석열"}, {"3", "심상정"}, {"4", "안철수"}}; // 후보자 배열
        int[] votes; // 투표 수 배열
        String elected = ""; // 당선인 이름

        while (true) { // 투표 수가 서로 다를 때까지 루프
            votes = createVotes();

            if (isSame(votes)) {
                votes = createVotes(); // 투표 수가 같을 경우 배열 재생성
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (votes[i] < votes[j]) {
                    elected = candidates[j][1]; // 득표 수가 가장 많은 사람 정하기
                }
            }
        }

        System.out.printf("[투표진행율]: %.2f%%, 10000명 투표 => %s\n", 100.00, elected);
        for (int i = 0; i < candidates.length; i++) {
            System.out.printf("[기호:%s] %s: %02.2f%%, (투표수: %d)\n", candidates[i][0], candidates[i][1], votes[i] / 100.00, votes[i]);
        }
        System.out.printf("[투표결과] 당선인: %s", elected);
    }

    static int[] createVotes () {
        int[] votes = new int[4];

        for (int i = 0; i < 10000; i++) { // 균등한 확률로 난수 생성
            int random =  new Random().nextInt(4);
            votes[random]++;
        }

        return votes;
    }

    static boolean isSame (int[] votes) {
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes.length; j++) {
                if (i == j) { // 인덱스가 같을 경우 스킵
                    continue;
                } else {
                    if (votes[i] == votes[j]) { // 투표 수가 같을 경우 true
                        return true;
                    }
                }
            }
        }
        return false; // 아닐 경우 false
    }
}
