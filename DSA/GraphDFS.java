//Name:-Vaishnavi Satish Deore
//Roll no.:-133 Div:-B Batch:-S3B

//Program of implementation of Graph DFS.
import java.util.*;
import java.io.*;
class GraphDFS
{
int v;
    LinkedList<Integer> adj[];
    Stack<Integer> s; // change 1
    GraphDFS(int v)
    {
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new LinkedList<>();
        }
        s=new Stack<Integer>(); // change 2
}
void edge(int v,int w)
{
adj[v].add(w);
}
 public void DFS(int a)
    {
        boolean nodes[]=new boolean[v];
        nodes[a]=true;
        s.push(a); // chnage 3
        while(s.size()!=0)
        {
            int c=s.pop(); // chnage 4
            System.out.println("Element popped is : "+c);
            for(int i=0;i<adj[c].size();i++)
            {
                int x=adj[c].get(i);
                if(!nodes[x])
                {
                    nodes[x]=true;
                    s.push(x);  // change 5
                }
            }
        }
    }



public static void main(String args[])
{
GraphDFS g=new GraphDFS(5);
g.edge(0,1);
g.edge(0,2);
g.edge(0,3);
g.edge(2,3);
g.edge(2,4);
System.out.println("Graph DFS :");
g.DFS(0);
}
}




