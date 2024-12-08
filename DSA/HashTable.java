//Name:-Vaishnavi Satish Deore
//Roll no.:-133 Div:-B Batch:-S3B

//Program of Implementation of HashTable using Linear Probing
import java.util.Scanner;	
 
class LinearProbing {
   
    private int currentsize, maxsize;
    private String[] keys;
    private String[] vals;
 
    public LinearProbing(int capacity)
    {
        currentsize = 0;
        maxsize = capacity;
        keys = new String[maxsize];
        vals = new String[maxsize];
    }
    public void makeEmpty()	 
    {
        currentsize = 0;
        keys = new String[maxsize];
        vals = new String[maxsize];
    }
    public int getSize() 	
    { 
	return currentsize; 
    }
 
    public boolean isFull()	
    {
        return currentsize == maxsize;
    }
 
    public boolean isEmpty() 	 
    { 
	return getSize() == 0; 
    }
   
    public boolean contains(String k)	 
    {
        return get(k) != null;
    }
 
    private int hash(String k)  
    {
       
        return Integer.parseInt(k)%maxsize;
    }
 
    public void insert(String k, String v)	   
    {
        int tmp = hash(k);
        int i = tmp;
        do {
            if (keys[i] == null) {
                keys[i] = k;
                vals[i] = v;
                currentsize++;
                return;
            }
 
            if (keys[i].equals(k)) {
                vals[i] = v;
                return;
            }

            i = (i + 1) % maxsize;
        }
        while (i != tmp);
    }

    public String get(String k)     
    {
        int i = hash(k);
        while (keys[i] != null) {
            if (keys[i].equals(k))
                return vals[i];
            i = (i + 1) % maxsize;
        }
        return null;
    }

    public void remove(String k)      	    
    {
       if (!contains(k))//other condition if(get(k)==null)
           return;
       int i = hash(k);
       while (!k.equals(keys[i]))
           i = (i + 1) % maxsize;
       keys[i] = vals[i] = null;
       
       for (i = (i + 1) % maxsize; keys[i] != null; i = (i + 1) % maxsize) 
   {
           String tmp1 = keys[i], tmp2 = vals[i];
           keys[i] = vals[i] = null;
           currentsize--;
           insert(tmp1, tmp2);
       }
       currentsize--;
   }
    public void printHashTable()	   
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxsize; i++)
            if (keys[i] != null)
                System.out.println(i+" "+keys[i] + " " + vals[i]);
        System.out.println();
    }
}
 
public class HashTable {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hash Table");
        System.out.println("Enter the size");
 
        LinearProbing l = new LinearProbing(sc.nextInt());
 
        char ch;
 
        do
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");
            System.out.println("4. clear");
            System.out.println("5. size");
            System.out.println("6. Display");
            int choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter key and value");
                l.insert(sc.next(), sc.next());
                break;
 	     
            case 2:
                System.out.println("Enter key");
                l.remove(sc.next());
                break;
 
            case 3:
                System.out.println("Enter key");
                System.out.println("Value = "+ l.get(sc.next()));
                break;
 
            case 4:
                l.makeEmpty();
                System.out.println("Hash table is cleared\n");
                break;
 
            case 5:
                System.out.println("Size = "+ l.getSize());
                break;
            
            case 6:
                System.out.println("display the hash table:");
                l.printHashTable();
                 break;

            default:
                System.out.println("Invalid choice\n ");
                break;
            }
            System.out.println("\nDo you want to continue (Type y or n) \n");
 
            ch = sc.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}