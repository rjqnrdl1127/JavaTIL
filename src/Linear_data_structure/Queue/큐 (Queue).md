# 큐 (Queue)

생성일: 2022년 7월 16일 오전 11:04
태그: #java, 선형자료구조

## 큐의 정의

> 큐는 컴퓨터 과학 분야에서 쓰이는 컴퓨터의 기본적인 자료 구조의 한가지로, 먼저 집어 넣은 데이터가 먼저 나오는 FIFO(First In First Out)구조로 저장하는 형식을 말한다.
>

![image.png](%E1%84%8F%E1%85%B2%20(Queue)%201ce7a980860e46878fbe9759bc3624f8/image.png)

## 큐의 연산 종류

- isEmpty(): 큐에 데이터가 없으면 true 있으면 false를 반환한다.
- push(): 데이터를 저장
- pop(); 가장 먼저 들어간 데이터를 제거한다
- peek(): 가장 먼저 들어간 데이터를 반환한다

## 큐 구현

### ArrayList를 이용한 구현

```java
import java.util.ArrayList;

public class QueueWithArrayList {
    ArrayList list;

    QueueWithArrayList() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) return true;
        else return false;
    }

    public void enqueue(Object data) {
        this.list.add(data);
    }

    public Object dequeue() {
        if (this.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return null;
        }

        Object data = this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Object peek() {
        if (this.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return null;
        }

        return this.list.get(0);
    }

    public void printQueue() {
        System.out.println(this.list);
    }

    public static void main(String[] args) {
        QueueWithArrayList queue = new QueueWithArrayList();
        queue.enqueue(1);
        queue.enqueue(0.1);
        queue.enqueue("가나다라");
        queue.printQueue();

        System.out.println(queue.peek());

        System.out.println(queue.dequeue());
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();
    }
}
```

```text
// 출력 결과
[1, 0.1, 가나다라]
1
1
[0.1, 가나다라]
[가나다라]
```

## 원형 큐

> **원형 큐는 선형 큐의 문제점을 보완하기 위한 자료구조입니다. 앞선 포스팅에서 선형큐의 문제점은 rear이 가르키는 포인터가 배열의 마지막 인덱스를 가르키고 있을 때 앞쪽에서 Dequeue로 발생한 배열의 빈 공간을 활용 할 수가 없었습니다. 원형큐에서는 포인터 증가 방식이 (rear+1)%arraysize 형식으로 변환하기 때문에 배열의 첫 인덱스부터 다시 데이터의 삽입이 가능해집니다.**
>