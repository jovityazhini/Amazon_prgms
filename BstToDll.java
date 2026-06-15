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

    static Node prev = null;
    static Node head = null;

    static void convertToDLL(Node root) {
        if (root == null)
            return;

        convertToDLL(root.left);

        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        convertToDLL(root.right);
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

    static void printForward(Node head) {
        Node temp = head;
        Node last = null;

        while (temp != null) {
            System.out.print(temp.data + " ");
            last = temp;
            temp = temp.right;
        }

        System.out.println();

        while (last != null) {
            System.out.print(last.data + " ");
            last = last.left;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree in preorder (-1 for NULL):");
        Node root = buildTree(sc);

        convertToDLL(root);

        printForward(head);

        sc.close();
    }
}
