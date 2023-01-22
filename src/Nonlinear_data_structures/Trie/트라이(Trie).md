# 트라이(Trie)

생성일: 2022년 7월 28일 오후 5:04
태그: #java, 비선형자료구조

## 트라이의 정의

![Untitled](%E1%84%90%E1%85%B3%E1%84%85%E1%85%A1%E1%84%8B%E1%85%B5(Trie)%2038cd21ea51ed4cc5834d47319e87bdd8/Untitled.png)

- 트라이란 문자열을 저장하고 효율적으로 탐색하기 위한 트리 형태의 자료구조입니다.
- 트리의 루트에서부터 자식들을 따라가면서 생서된 문자열들이 트라이 자료구조에 저장되어 있다고 볼 수 있습니다. 저장된 단어는 끝을 표시하는 변수를 추가해서 저장된 단어의 끝을 구분할 수 있습니다.
- DFS 형태로 검색을 해보면 사진의 번호에 나와있듯이 단어들이 자료구조에 들어가 있음을 알 수 있습니다.

## 사용 목적

- 문자열의 탐색을 하고자할 때 시간복잡도를 보면 알 수 있습니다. 단순하게 하나씩 비교하면서 탐색을 하는 것보다 훨씬 효율적입니다. 단, 빠르게 탐색이 가능하다는 장점이 있지만, 각 노드에서 자식들에 대한 포인터들을 배열로 모두 저장하고 있다는 점에서 저장 공간의 크기가 크다는 단점도 있습니다.
- 검색어 자동완성, 사전에서 찾기 그리고 문자열 검사에 사용할 수 있습니다.

## 시간 복잡도

- L: 제일 긴 문자열의 길이, M: 총 문자열들의 개수
- 생성신 시간 복잡도: O(M * L), 모든 문자열들을 넣어야하니 M개에 대해서 트라이 자료구조에 넣는 것은 가장 긴 문자열 길이만큼 걸리니  L만큼 걸리기 때문
- 탐색시 시간복잡도: O(L), 트리를 타고 들어가봤자 가장 긴 문자열의 길이 만큼만 탐색하기 때문

~~~java
import java.util.HashMap;

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

public class Trie {
    Node root;
    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }
            
            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return true;
    }
}
~~~