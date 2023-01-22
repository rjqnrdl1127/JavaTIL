package Linear_data_structure.Queue;

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
