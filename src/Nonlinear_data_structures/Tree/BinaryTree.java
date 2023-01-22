package Nonlinear_data_structures.Tree;
// 배열을 이용하여 이진 트리 구현

public class BinaryTree {

    char[] arr;

    public BinaryTree(char[] data) {
        this.arr = data.clone();
    }

    public void preOrder(int index) {
        System.out.print(this.arr[index] + " ");

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < this.arr.length) {
            this.preOrder(left);
        }

        if (right < this.arr.length) {
            this.preOrder(right);
        }
    }

    public void inOrder(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < this.arr.length) {
            this.preOrder(left);
        }

        System.out.print(this.arr[index] + " ");

        if (right < this.arr.length) {
            this.preOrder(right);
        }
    }

    public void postOrder(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < this.arr.length) {
            this.preOrder(left);
        }

        if (right < this.arr.length) {
            this.preOrder(right);
        }

        System.out.print(this.arr[index] + " ");
    }

    public void levelOrder() {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("==Preorder==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("==Inorder==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("==Postorder==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("==Levelorder==");
        bt.levelOrder();
        System.out.println();
    }
}
