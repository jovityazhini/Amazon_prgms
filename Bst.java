import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static boolean isBST(Node root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean check(Node node, long min, long max) {
        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        return check(node.left, min, node.data) &&
               check(node.right, node.data, max);
    }

    static Node buildTree(Scanner sc) {
        int val = sc.nextInt();

        if (val == -1)
            return null;

        Node root = new Node(val);

        root.left = buildTree(sc);
        root.right = buildTree(sc);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree nodes in preorder (-1 for NULL):");
        Node root = buildTree(sc);

        if (isBST(root))
            System.out.println(1);
        else
            System.out.println(0);

        sc.close();
    }
}
