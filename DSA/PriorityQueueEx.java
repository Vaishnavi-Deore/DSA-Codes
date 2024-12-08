//Name:-Vaishnavi Satish Deore
//Roll no.:-133 Div:-B Batch:-S3B
//Program of implementation of Priority Queue using heap data structure.
import java.util.Scanner;
class PriorityQueueEx
{
	static int size=-1;
	static int a[]=new int[50];
	static int parent(int i)
	{
		return (i-1)/2;
	}
	
	static int leftChild(int i)
	{
		return (2*i)+1;
	}

	static int rightChild(int i)
	{
		return (2*i)+2;
	}

	static int getMax()
	{
		return a[0];
	}

	static void insert(int p)
	{
		size=size+1;
		a[size]=p;
		ShiftUp(size);
		System.out.println("Element Inserted Successfully");
	}

	static void ShiftUp(int i)
	{
		int parent=(i-1)/2;
		while(i>0 && a[parent(i)]<a[i])
		{
			swap(parent(i),i);
			i=parent(i);
		}
	}

	static void swap(int i,int p)
	{
		int temp=a[i];
		a[i]=a[p];
		a[p]=temp;
	}
	
	public void display()
	{
		if(size==-1)
		{
			System.out.println("Priority Queue is empty");
			return;
		}
		else
		{
			for(int i=0;i<=size;i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	}

	static int extractMax()
	{
		int result=a[0];
		a[0]=a[size];
		size=size-1;
		shiftDown(0);
		return result;
	}

	static void shiftDown(int i)
	{
		int max=i;
		int l=leftChild(i);
		int r=rightChild(i);

		if(l<=size && a[l]>a[max])
		{
			max=l;
		}
	
		if(r<=size && a[r]>a[max])
		{
			max=r;
		}

		if(i!=max)
		{
			swap(i,max);
			shiftDown(max);
		}

		
	}

	static void remove(int n)
	{
		a[n]=getMax()+1;
		ShiftUp(n);
		extractMax();
	}

	static void changePriority(int i,int newPriority)	
	{
		int oldPriority=a[i];
		a[i]=newPriority;
		
		if(oldPriority<a[i])
		{
			ShiftUp(i);
		}
		else
		{
			shiftDown(i);
		}
	}
		
}	
	
class PriorityQueue
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		PriorityQueueEx PQ=new PriorityQueueEx();
		System.out.println("Enter the size : ");
		int size=sc.nextInt();
		//int size2=-1;
		int repeat;
		do
		{
			System.out.println("1.Insert\n2.Display\n3.Remove\n4.Change Priority\n5.Extract Max");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					//System.out.println("Enter the size : ");
					//size=sc.nextInt();
					//size2+=size1;
					System.out.println("Enter the element you want  to insert : ");
					for(int i=0;i<size;i++)
					{
						int element=sc.nextInt();
						PQ.insert(element);
					}
					break;
						
				case 2:
					System.out.println("Elements are : ");
					PQ.display();
					break;

				case 3:
					System.out.println("Enter the index to delete : ");
					int i=sc.nextInt();
					if(i>=0 && i<=size)
					{
						PQ.remove(i);
						System.out.println("Element removed successfully");
					}
					else
					{
						System.out.println("Invalid Index");
					}
					break;

				case 4:
					System.out.println("Enter index to change Priority : ");
					int index=sc.nextInt();
					System.out.println("Enter the new priority : ");
					int np=sc.nextInt();
					PQ.changePriority(index,np);					
					break;

				case 5:
					System.out.println("Extracted Max element in Priority queue is : "+PQ.extractMax());
					break;
	
				default:
					System.out.println("Invalid Choice");
			}
			System.out.println("Do you want to continue : (1.Yes and 2.No)");
			repeat=sc.nextInt();
		}while(repeat==1);
	}
}