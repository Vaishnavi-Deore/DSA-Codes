//Name:-Vaishnavi Satish Deore
//Roll no.:-133 Div:-B Batch:-S3B
//Program of Implementation of HashTable using Chaining.

import java.util.LinkedList;
import java.util.Scanner;

class Hash_table{
    int size, key;
    LinkedList<Integer>[] table;
    public Hash_table(int size){
        this.size=size;
        table=new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i]=new LinkedList<>();
        }
    }
    private int HashFun(int key){
        return key % size;
    }
    public void insert(int key){
        int index=HashFun(key);
        table[index].add(key);
    }
    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.print("Index "+i+" -> ");
            for (Integer key: table[i]) {
                System.out.print(key+" ->");
            }
            System.out.println("null");
        }
    }
    public boolean search(int key){
        int index = HashFun(key);
        return table[index].contains(key);
    }

}
public class HashChaining {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Table Size: ");
        int size=sc.nextInt();
        System.out.println("Enter the no. of keys you would enter: ");
        int n=sc.nextInt();
        int ch,choice,key;
        Hash_table h=new Hash_table(size);
        do{
            System.out.println("Enter your choice: \n 1.Insert \n 2.Display \n 3.Search");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter the Key:");
                    for (int i = 0; i < n; i++) {
                        key=sc.nextInt();
                        h.insert(key);
                    }
                    break;
                case 2:
                    h.display();
                    break;
                case 3:
                    System.out.println("Enter the key to search:");
                    int element=sc.nextInt();
                    if(h.search(element)){
                        System.out.println("Element "+element+"  Found...!");
                    }
                    else{
                        System.out.println("Element "+element+"  not Found.");
                    }
                    break;
            }
            System.out.println("Do you want to continue? YES = 1 :: N0 = 0");
            choice= sc.nextInt();
        }while(choice!=0);
    }
}