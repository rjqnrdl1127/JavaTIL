package Linear_data_structure.Stack;

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
