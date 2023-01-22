package Linear_data_structure.LinkedList;

class Node {
    private String data;
    public Node link;

    public Node() {
        this.data = null;
        this.link = null;
    }

    public Node(String data) {
        this.data = data;
        this.link = null;
    }

    public Node(String data, Node link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}
public class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }
    // 중간 삽입
    public void insertNode(Node preNode, String data) {
        Node newNode = new Node(data); // 새로운 노드 생성
        // 새로운 노드의 link가 preNode의 다음 노드를 참조하도록 함.
        newNode.link = preNode.link;
        // preNode의 link가 새로운 노드를 참조하도록 함.
        preNode.link = newNode;
    }
    // 마지막에 삽입
    public void insertNode(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            // head 노드가 null인 경우 새로운 노드를 head 노드로 사용
            this.head = newNode;
        } else {
            // temp 노드가 head를 참조
            // tempNode는 마지막 노드를 찾아서 참조하기 위해 사용
            Node tempNode = head;
            // 마지막 노드 탐색
            while(tempNode.link != null) {
                tempNode = tempNode.link;
            }
            // 마지막 노드가 새로운 노드를 참조
            tempNode.link = newNode;
        }
    }
    // 중간 노드 삭제
    public void deleteNode(String data) {
        // preNode를 head 노드로 설정
        Node preNode = head;
        // tempNode는 head 노드 다음 노드로 설정
        Node tempNode = head.link;
        // data와 같은 데이터를 갖고 있는 Node를 찾는다.
        if (data.equals(preNode.getData())) {
            head = preNode.link;
            preNode.link = null;
        } else {
            while(tempNode != null) {
                if (data.equals(tempNode.getData())) {
                    if (tempNode.link == null) {
                        preNode.link = null;
                    } else {
                        preNode.link = tempNode.link;
                        tempNode.link = null;
                    }
                    break;
                } else {
                    preNode = tempNode;
                    tempNode = tempNode.link;
                }
            }
        }
    }
    // 마지막 노드 삭제
    public void deleteNode() {
        Node preNode;
        Node tempNode;

        if (head == null) {
            return;
        }

        if (head.link == null) {
            head = null;
        } else {
            preNode = head;

            tempNode = head.link;

            while (tempNode.link != null) {
                preNode = tempNode;
                tempNode = tempNode.link;
            }

            preNode.link = null;
        }
    }
}
