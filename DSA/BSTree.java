import java.util.Scanner;

class Node1 {
    int key;
    Node1 left, right;

    public Node1(int key) {
        this.key = key;
        left = right = null;
    }
}

class Operation {
    int Mini;
    Node1 root;

    // INSERT
    public void insert(int key) {
        root = compare(root, key);
        /*
         * Node1 newNode1 = new Node1(key);
         * if (root == null) {
         * root = newNode1;
         * } else {
         * compare(root, newNode1);
         * }
         */
    }

    public Node1 compare(Node1 root, int key) {
        if (root == null) {
            root = new Node1(key);
            return root;
        } else if (root.key <= key) {
            root.right = compare(root.right, key);
        } else if (root.key > key) {
            root.left = compare(root.left, key);
        }

        return root;
    }

    public void display() {
        System.out.println("Inorder traversal");
        inorder_traversal(root);
    }

    private void inorder_traversal(Node1 current) {
        if (current != null) {
            inorder_traversal(current.left);
            System.out.println(current.key);
            inorder_traversal(current.right);
        }

    }

    public void search() {
        Scanner s = new Scanner(System.in);
        System.out.println("ENTER THE ELEMENT TO SEARCH:");
        int target = s.nextInt();
        if (search_element(root, target)) {
            System.out.println("ELEMENT FOUND...");
        } else {
            System.out.println("ELEMENT NOT FOUND...");
        }
    }

    private boolean search_element(Node1 root, int target) {
        if (root == null) {
            return false;
        } else if (target == root.key) {
            return true;
        } else if (target < root.key) {
            return search_element(root.left, target);
        } else {
            return search_element(root.right, target);
        }
    }

    // MIN FIND
    public int min(Node1 root) {
        if (root == null) {
            return 0;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.key;

    }

    // MAX find
    public int max(Node1 root) {
        if (root == null) {
            return 0;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.key;

    }

    Node1 deleteNode(Node1 root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {

            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                root.key = min(root.right);
                root.right = deleteNode(root.right, root.key);
            }

        }
        return root;
    }
}

public class BSTree {
    public static void main(String[] args) {
        Operation o = new Operation();
        Scanner s = new Scanner(System.in);
        int num;
        int choice;
        do {
            System.out.println("Enter your choice\n1.Insert\n2.Display\n3.Search\n4.Minimum\n5.maximum\n6.delete node3");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the data");
                    int key = s.nextInt();
                    o.insert(key);
                    break;
                case 2:
                    o.display();
                    break;
                case 3:
                    o.search();
                    break;
                case 4:
                    // o.min(o.root);
                    System.out.println("The minimum value is:" + o.min(o.root));
                    break;
                case 5:
                    // o.max(o.root);
                    System.out.println("The maximum value is:" + o.max(o.root));

                    break;
                case 6:
                    System.out.println("Enter the element which u want to dlt:");
                    int c = s.nextInt();
                    o.deleteNode(o.root, c);
                    System.out.println("Element deleted successfully");
                    break;
                default:
                    System.out.println("Enter valid choice....");
            }
            System.out.println("Do you want to continue.. \n if yes(1)\n if No(0)");
            num = s.nextInt();

        } while (num != 5);
    }
}