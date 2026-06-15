import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static int leafLevel = -1;

    static boolean checkLeaves(Node root, int level) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null) {
            if (leafLevel == -1) {
                leafLevel = level;
                return true;
            }
            return leafLevel == level;
        }

        return checkLeaves(root.left, level + 1) &&
               checkLeaves(root.right, level + 1);
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

        System.out.println("Enter tree in preorder (-1 for NULL):");
        Node root = buildTree(sc);

        System.out.println(checkLeaves(root, 0) ? 1 : 0);

        sc.close();
    }
}
