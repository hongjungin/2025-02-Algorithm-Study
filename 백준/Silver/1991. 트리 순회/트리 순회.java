import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            tree.add(parent, left, right);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Map<Character, Node> nodes = new HashMap<>();
    Node root;

    void add(char parent, char left, char right) {
        nodes.putIfAbsent(parent, new Node(parent));
        Node parentNode = nodes.get(parent);

        // 왼쪽 자식이 존재하면
        if (left != '.'){
            nodes.putIfAbsent(left, new Node(left));  // 왼쪽 자식 노드가 없다면 생성
            parentNode.left = nodes.get(left);        // 부모의 왼쪽으로 연결
        }
        // 오른쪽 자식이 존재하면
        if (right != '.'){
            nodes.putIfAbsent(right, new Node(right));
            parentNode.right = nodes.get(right);
        }

        if (root == null) {
            root = parentNode;
        }
    }

    // 전위 순회
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }
    // 중위 순회
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }
    // 후위 순회
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }

}