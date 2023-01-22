# 우선 순위 큐(Priority Queue)

생성일: 2022년 7월 28일 오후 5:16
태그: #java, 비선형자료구조

## 우선 순위 큐(Priority Queue)의 정의

- 우선순위가 높은 데이터가 먼저 반환되는 자료구조
- 모든 데이터에 우선순위가 있음.
- 큐에서 데이터를 꺼낼 때 우선순위가 높은 순으로 꺼냄.
- 우선 순위가 같은 경우는 FIFO

## 우선순위 큐 - 구현

- 배열
- 연결 리스트
- 힙

| 시간 복잡도 | enqueue() | dequeue() |
| --- | --- | --- |
| 정렬된 배열 | O(N) | O(1) |
| 정렬된 연결 리스트 | O(N) | O(1) |
| 힙 | O(logN) | O(logN) |

```java
import java.util.*;
// 연결 리스트를 이용한 구현
public class Main {
    public static void enqueue(LinkedList<Integer> list, int data) {
        int idx = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > data) { // 데이터의 위치 선정
                idx = i;
                break;
            }
        }

        list.add(idx, data); // 저장
    }

    public static Integer dequeue(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return null;
        }

        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args) {
        // 연결리스트를 이용한 우선순위 큐
        System.out.println("== 연결리스트 방식의 우선순위 큐 ==");
        LinkedList<Integer> pqList = new LinkedList();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 9);
        System.out.println(pqList);

        System.out.println(dequeue(pqList));
        System.out.println(dequeue(pqList));
        System.out.println(pqList);
        System.out.println();

        // 자바 기본 PriorityQueue 사용
        System.out.println("== 자바 기본 우선순위 큐 ==");
        // 우선순위: 낮은 숫자 순
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.add(7);
        queue.add(9);
        System.out.println(Arrays.toString(queue.toArray()));

        // 우선순위: 높은 숫자 순
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
        queue2.add(1);
        queue2.add(3);
        queue2.add(5);
        queue2.add(7);
        queue2.add(9);
        System.out.println(Arrays.toString(queue2.toArray()));
    }
}
```

```
== 연결리스트 방식의 우선순위 큐 ==
[1, 3, 5, 7, 9]
1
3
[5, 7, 9]

== 자바 기본 우선순위 큐 ==
[1, 3, 5, 7, 9]
[9, 7, 3, 1, 5]
```