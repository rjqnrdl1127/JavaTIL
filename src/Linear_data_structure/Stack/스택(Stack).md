# 스택(Stack)

생성일: 2022년 7월 13일 오전 2:58
태그: #java, 선형자료구조

## 스택의 정의

스택은 후입선출 자료구조로써, 마지막에 들어온 데이터가 먼저 나가는 구조

## 스택의 연산 종류

- pop(): 스택에서 가장 위에 있는 항목을 제거한다.
- push(item): item 하나를 스택의 가장 윗 부분에 추가한다.’
- peek(): 스택의 가장 위에 있는 항목을 반환한다.
- isEmpty(): 스택이 비어 있을 때 true를 반환한다.

## 스택 구현

### 배열을 이용한 구현

```java
import java.util.Arrays;

public class StackWithArray {

    Object[] arr;
    int top = -1;

    StackWithArray(int size) {
        arr = new Object[size];
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.top == this.arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        if (this.isFull()) {
            System.out.println("스택이 비어있습니다.");
            return;
        }

        this.top += 1;
        this.arr[this.top] = data;
    }

    public void push(double data) {
        if (this.isFull()) {
            System.out.println("스택이 비어있습니다.");
            return;
        }

        this.top += 1;
        this.arr[this.top] = data;
    }

    public void push(String data) {
        if (this.isFull()) {
            System.out.println("스택이 비어있습니다.");
            return;
        }

        this.top += 1;
        this.arr[this.top] = data;
    }

    public Object pop() {
        if (this.isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return null;
        }

        Object data = this.arr[this.top];
        this.top -= 1;
        return data;
    }

    public Object peek() {
        if (this.isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return null;
        }

        return this.arr[this.top];
    }

    public void printStack() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        StackWithArray array = new StackWithArray(5);
        System.out.println(array.isEmpty());

        array.push(1);
        array.push(0.1);
        array.push("가나다라");
        System.out.println(array.isEmpty());
        array.printStack();

        System.out.println(array.peek());
        array.pop();
        array.printStack();
    }
}
```

```java
true
false
[1, 0.1, 가나다라, null, null]
가나다라
[1, 0.1, 가나다라, null, null]
```

### List를 이용한 구현

```java
import java.util.ArrayList;

public class Stack {
    ArrayList list;

    Stack() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) return true;
        else return false;
    }

    public void push(int data) {
        this.list = new ArrayList<Integer>();
        this.list.add(data);
    }

    public void push(double data) {
        this.list.add(data);
    }

    public void push(String data) {
        this.list.add(data);
    }

    public Object pop() {
        if (this.isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return null;
        }

        this.list.remove(this.list.size() - 1);
        return this.list.get(this.list.size() - 1);
    }

    public Object peek() {
        if (this.isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return null;
        }

        return this.list.get(this.list.size() - 1);
    }

    public void printStack() {
        System.out.println(this.list);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());

        // 자료 추가
        stack.push(1);
        stack.push(0.1);
        stack.push("가나다라");
        System.out.println(stack.isEmpty());
        stack.printStack();

        System.out.println(stack.peek());
        stack.pop();
        stack.printStack();
    }
}
```

```java
// 실행 결과
true
false
[1, 0.1, 가나다라]
가나다라
[1, 0.1]
```

## 스택의 장점

- 구조가 단순해서, 구현이 쉽다.
- 데이터 저장 / 읽기 속도가 빠르다.

## 스택의 단점

- 데이터 최대 갯수를 미리 정해야 한다.
- 저장 공간의 낭비가 발생할 수 있다.
- 최대 갯수만큼 저장 공간을 확보해야 한다.

## 스택의 사용 사례

- 재귀 알고리즘
    - 재귀적으로 함수를 호출해야 하는 경우에 임시 데이터를 스택에 넣어준다.
    - 재귀함수를 빠져 나와 퇴각 검색을 할 때는 스택에 넣어 두었던 임시 데이터를 꺼내 줘야 한다.
    - 스택은 이런 일련의 행위를 직관적으로 가능하게 해 준다.
    - 또한 스택은 재귀 알고리즘을 반복적 형태를 통해서 구현할 수 있게 해준다.
- 웹 브라우저 방문기록(뒤로가기)
- 실행 취소(undo)
- 역순 문자열 만들기
- 수식의 괄호 검사 (연산자 우선순위 표현을 위한 관호 검사)
- 후위 표기법 계산

## References

[Serzhul’s Blog](https://serzhul.io/Data%20Structure/%EC%8A%A4%ED%83%9D(Stack)/)

[[자료구조] 스택(Stack)이란](https://gmlwjd9405.github.io/2018/08/03/data-structure-stack.html)

[Algorithms 개정 4판](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9791160506761)