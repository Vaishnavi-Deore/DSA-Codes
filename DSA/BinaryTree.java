//Name:-Vaishnavi Satish Deore
//Roll no.:-133 Div:-B Batch:-S3B
//Program of Implementation of Binary Tree
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class Binary {
    Node root;
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            whereToInsert(root, newNode);
        }
    }

    private void whereToInsert(Node currNode, Node newNode) {
        Scanner sc = new Scanner(System.in);
        int c;
        do {
            System.out.println("Element " + currNode.data + " Where you want to insert 1.Left 2.Right");
            int b = sc.nextInt();
            if (b == 1) {
                if (currNode.left == null) {
                    currNode.left = newNode;
                    break;
                }
                currNode = currNode.left;
            } else if (b == 2) {
                if (currNode.right == null) {
                    currNode.right = newNode;
                    break;
                }
                currNode = currNode.right;
            } else {
                System.out.println("Enter a valid choice:");
            }
            System.out.println("Do you want to continue 1.Yes , 0.No");
            c = sc.nextInt();
        } while (c != 0);
    }

    public void display() {
        System.out.println("Inorder Traversal");
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);
    }

    public int cntNode(Node root) {
        if (root == null) {
            return 0;
        } else {
            int cnt = 1;
            cnt += cntNode(root.left);
            cnt += cntNode(root.right);
            return cnt;
        }
    }

    public void printLeaves(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public int countt(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {

            return 1;
        }
        return countt(root.left) + countt(root.right);

    }
//another way to count no. of leaves or leaf or children
   /*  public int countN(Node root) {
        if (root == null)
            return 0;

        else {
            if (root.left == 0 && root.right == 0) {
                int ct = 1;
                ct += countN(root.left);
                ct += countN(root.right);
                return ct;
            }
        }
    }*/

    public int Heightt(Node root) {
        if (root == null) {
            return 0;
        }
        int leftheight = Heightt(root.left);
        int rightheight = Heightt(root.right);
        if(leftheight>rightheight)
        {
            return leftheight+1;
        }
        else{
            return rightheight+1;
        }
         //another way to find height of tree
        //int max = Math.max(leftheight, rightheight) + 1;
        //return max;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Binary b = new Binary();
        int repeat;
        do {
            System.out.println(
                    "Enter the operation you want to perform: 1.Insertion , 2.Display , 3.countNode , 4.Print Leaves , 5.count of leaves, 6.maxHeight");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element you want to insert");
                    int a = sc.nextInt();
                    b.insert(a);
                    break;

                case 2:
                    System.out.println("the display elements");
                    b.display();
                    break;

                case 3:
                    System.out.println("Count the number of Nodes " + b.cntNode(b.root));
                    break;

                case 4:
                    System.out.println("Leaves of Trees :");
                    b.printLeaves(b.root);
                    break;

                case 5:
                    System.out.println("count of leaves:" + b.countt(b.root));
                    break;

                case 6:
                    System.out.println("Maximum height of BT :" + b.Heightt(b.root));
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("Do you want to continue 1.Yes , 0.No");
            repeat = sc.nextInt();
        } while (repeat == 1);
    }
}