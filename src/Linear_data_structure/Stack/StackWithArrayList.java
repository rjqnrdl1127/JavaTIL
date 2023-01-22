package Linear_data_structure.Stack;
// 스택 자료구조

import java.util.ArrayList;

public class StackWithArrayList {
    ArrayList list;

    StackWithArrayList() {
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

//    public static void main(String[] args) {
//        StackWithArrayList stack = new StackWithArrayList();
//        System.out.println(stack.isEmpty());
//
//        // 자료 추가
//        stack.push(1);
//        stack.push(0.1);
//        stack.push("가나다라");
//        System.out.println(stack.isEmpty());
//        stack.printStack();
//
//        System.out.println(stack.peek());
//        stack.pop();
//        stack.printStack();
//    }
}
