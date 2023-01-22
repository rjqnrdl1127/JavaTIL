# 연결리스트(LinkedList)

생성일: 2022년 7월 19일 오전 12:51
태그: #java, 선형자료구조

## 연결리스트의 정의

> 연결리스트는 재귀적인 데이터 구조로 공백(null)이거나 제네릭 항목과 다른 연결 리스트에 대한 참조를 가진 노드의 참조이다. 배열에 비해서 데이터의 추가 / 삭제가 용이하나, 인덱스가 없는 리스트의 특징으로 인하여 특정 요소에 접근하기 위해서는 순차적으로 탐색을 필요로 하므로 일반적으로 탐색 속도가 떨어집니다. 즉, 탐색 또는 정렬을 자주하는 경우엔 배열을 사용하고 데이터의 추가 / 삭제가 많은 경우 연결 리스트를 사용하는 것을 권장합니다.
> 
- 노드: 어떤 임의의 데이터를 가진 독립체로 연결리스트 구성을 우해 다른 노드에 대한 참조(메모리 주소)를 가지고 있는 것이 특징이다.

## 연결리스트의 종류

- 단일 연결 리스트(Singly Linked List)
    
    각 노드가 다음 노드에 대해서만 참조하는 가장 단순한 형태의 연결 리스트입니다.
    
    일반적으로 큐를 구현할 때 사용됩니다.
    
- 이중 연결 리스트(Doubly Linked List)
    
    각 노드가 이전 노드, 다음 노드에 대해서 참조하는 형태의 연결 리스트입니다.
    
    삭제가 간편하며 단일 연결 리스트에 비해 데이터 손상에 강하지만, 관리할 참조가 2개이기 때문에 정렬의 경우 작업량이 더 많아집니다.
    

## 연결리스트 구현

```java
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
```