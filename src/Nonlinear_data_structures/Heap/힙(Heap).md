# 힙(Heap)

생성일: 2022년 7월 28일 오후 4:04
태그: #java, 비선형자료구조

## 힙의 정의

- 완전 이진 트리 형태
- 중복 값 허용
- 반 정령 상태(형제 노드간의 크기에 대한 우선순위는 상관 없음)
- 최소값 또는 최대값을 빠르게 찾아내는데 유용한 자료구조(최소힙, 최대힙)

## 최소 힙(Min Heap)

- 부모 노드의 키가 자식노드의 키보다 작거나 같은 형태

## 최대 힙(Max Heap)

- 부모 노드의 키가 자식 노드의 키보다 크거나 같은 형태

## 최소 힙 구현

- ArrayList를 사용하여 가변 배열 형태로 구현
- 삽입 방법
    1. 배열의 마지막 위치에 데이터를 저장
    2. 부모 노드의 위치에 있는 데이터와 크기 비교 후 결과에 따라 두 데이터의 위치 교체
    3. 2번 과정을 반복한다.
- 삭제 방법
    1. 힙 기준 최상위 노드를 반환 후 삭제한다.
    2. 최상위 노드에 가장 마지막에 위치한 데이터를 저장한다.
    3. 자식 노드들과 비교하여 둘 중 더 작은 데이터와 위치를 교체한다.
    4. 4번 과정을 반복한다.

```java
import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 더미 데이터 저장
    }

    public void insert(int data) { // 힙에 데이터 저장하는 메서드
        heap.add(data); // 데이터 삽입

        int cur = heap.size() - 1; // 삽입한 데이터의 위치(인덱스)
        while(cur > 1 && heap.get(cur / 2) > heap.get(cur)) { // 부모 노드의 키보다 작다면 자리를 바꾼다.
            int parentVal = heap.get(cur / 2);  // 부모 노드의 키 값
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }

    public Integer delete(){
        if (heap.size() == 1) {
            System.out.println("Heap is empty!");
            return null;
        }

        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while(true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) { // 자식 노드가 모두 있는 경우
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) { // 자식 노드가 하나인 경우
                targetIdx = leftIdx;
            } else { // leaf 노드인 경우
                break;
            }

            if (heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target; // 최상위 노드를 반환
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
        System.out.println("== 데이터 삽입 ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
    }
}
```

```
== 데이터 삽입 ==
10 40 30 
10 40 30 50 60 70 
10 40 20 50 60 70 30 
10 30 20 40 60 70 30 50 

== 데이터 삭제 ==
삭제: 10
20 30 30 40 60 70 50 
삭제: 20
30 30 50 40 60 70 
삭제: 30
30 40 50 70 60
```

## 최대 힙(Max Heap) 구현

- ArrayList를 사용하여 가변 배열 형태로 구현
- 삽입 방법
    1. 배열의 마지막 위치에 데이터를 저장
    2. 부모 노드의 위치에 있는 데이터와 크기 비교 후 결과에 따라 두 데이터의 위치 교체
    3. 2번 과정을 반복한다.
- 삭제 방법
    1. 힙 기준 최상위 노드를 반환 후 삭제한다.
    2. 최상위 노드에 가장 마지막에 위치한 데이터를 저장한다.
    3. 자식 노드들과 비교하여 둘 중 더 큰 데이터와 위치를 교체한다.
    4. 4번 과정을 반복한다.

```java
import java.util.ArrayList;

class MaxHeap {
    ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 더미 데이터 저장
    }

    public void insert(int data) { // 힙에 데이터 저장하는 메서드
        heap.add(data); // 데이터 삽입

        int cur = heap.size() - 1; // 삽입한 데이터의 위치(인덱스)
        while(cur > 1 && heap.get(cur / 2) < heap.get(cur)) { // 부모 노드의 값보다 크다면 자리를 바꾼다.
            int parentVal = heap.get(cur / 2);  // 부모 노드의 키 값
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }

    public Integer delete(){
        if (heap.size() == 1) {
            System.out.println("Heap is empty!");
            return null;
        }

        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while(true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (heap.get(cur) > heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        MaxHeap minHeap = new MaxHeap();
        System.out.println("== 데이터 삽입 ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
    }
}
```

```
== 데이터 삽입 ==
40 30 10 
70 50 60 30 40 10 
70 50 60 30 40 10 20 
70 50 60 30 40 10 20 30 

== 데이터 삭제 ==
삭제: 70
60 50 30 30 40 10 20 
삭제: 60
50 40 30 30 20 10 
삭제: 50
40 30 30 10 20
```