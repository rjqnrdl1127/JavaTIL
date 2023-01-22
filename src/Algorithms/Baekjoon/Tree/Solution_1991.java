package Algorithms.Baekjoon.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이진 트리 구현과 순회하는 문제
public class Solution_1991 {

    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 노드의 개수

        for(int i=0;i<n;i++) { // 노드간의 관계를 구성
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0); // 루트 노드
            char left = st.nextToken().charAt(0); // 왼쪽 노드
            char right = st.nextToken().charAt(0); // 오른쪽 노드

            insertNode(head, root,left,right);

        }

        preOrder(head); // 전위 순회 출력
        System.out.println();
        inOrder(head); // 중위 순회 출력
        System.out.println();
        postOrder(head); // 후위 순회 출력
        System.out.println();



    }

    // 이진 트리를 구성하는 노드
    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node temp, char root, char left, char right) {

        if (temp.value == root) {
            temp.left = (left == '.' ? null : new Node(left,null,null));
            temp.right = (right == '.' ? null : new Node(right,null,null));
        }
        else {
            if(temp.left != null) insertNode(temp.left, root, left, right);
            if(temp.right != null) insertNode(temp.right, root, left, right);
        }
    }
    // 전위 순회: 루트 -> 왼쪽 노드 -> 오른쪽 노드
    public static void preOrder(Node node) {
        if(node ==null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    // 중위 순회: 왼쪽 노드 -> 루트 -> 오른쪽 노드
    public static void inOrder(Node node) {
        if(node ==null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    // 후위 순회: 왼쪽 노드 -> 오른쪽 노드 -> 루트
    public static void postOrder(Node node) {
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}