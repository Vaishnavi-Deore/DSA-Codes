//Name:-Vaishnavi Satish Deore
//SYIT Div:-B and Roll no.:-133

//Program of Implementation of Binary Search Tree
import java.util.Scanner;

class Node {
    int val;
    Node right, left;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Binary {
    Node root;
//insert 
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }
//display 
    public void display() {
        System.out.println("Inorder Traversal");
        inOrder(root);
    }
// traversing
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(" " + root.val);
            inOrder(root.right);
        }
    }
//searching 
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element which you want to search: ");
        int value = sc.nextInt();
        if (search(root, value)) {
            System.out.println("Element Found");
        } else {
            System.out.println("Not Found");
        }
    }

    private boolean search(Node root, int value) {

        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        } else if (value < root.val) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }

    }

    // Find MIN
    public int min(Node root) {
        if (root == null) {
            return 0;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.val;

    }

    // find MAX
    public int max(Node root) {
        if (root == null) {
            return 0;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;

    }

    Node deleteNode(Node root, int val) {
        if (root == null) {
            return root;
        }
        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {

            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                root.val = min(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}
// Main Class
public class Binarysearchtree1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Binary b = new Binary();//object of class

        int again;
        do {
            System.out.println("Enter your choice\n1.Insert\n2.Display\n3.Search\n4.Minimum\n5.maximum\n6.delete");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element you want to insert: ");
                    int val = sc.nextInt();
                    b.insert(val);
                    break;

                case 2:
                    b.display();
                    break;

                case 3:
                    b.search();
                    break;
                case 4:

                    System.out.println("The minimum value is:" + b.min(b.root));
                    break;
                case 5:

                    System.out.println("The maximum value is:" + b.max(b.root));

                    break;
                case 6:
                    System.out.println("Enter the element which u want to dlt:");
                    int c = sc.nextInt();
                    b.deleteNode(b.root, c);
                    System.out.println("Element deleted successfully");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("\nDo you want to perform another operation? (1.Yes , 0.No): ");
            again = sc.nextInt();
        } while (again != 0);

        sc.close();
    }
}
