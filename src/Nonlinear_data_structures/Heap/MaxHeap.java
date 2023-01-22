package Nonlinear_data_structures.Heap;

import java.util.ArrayList;

// 최대 힙
// ArrayList를 이용하여 구현
public class MaxHeap {
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
