import java.util.Scanner;
import java.util.Arrays;
public class Prims1 {
  static void primsOT(int pcost[][],int a){
    int mincost=0;
    int edge=1;
    Boolean[] vis=new Boolean[a];
    Arrays.fill(vis,false);
    vis[0]=true;
    while(edge<a){
          int min=99;
          int x=0,y=0;
    
    for(int i=0;i<a;i++){
      if(vis[i]==true){
        for(int j=0;j<a;j++){
          if(vis[j]!=true&& min>pcost[i][j]){
            min=pcost[i][j];
            x=i;
            y=j;
          }
        }
        }
      }
      vis[y]=true;
      System.out.println("Edgecount "+edge++ +"min cost is"+ " "+ x+" "+y+" "+min);
      mincost=mincost+pcost[x][y];
    }
    System.out.println("mincost:"+mincost);
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the no of vertices:");
    int a=sc.nextInt();
    int pcost[][]=new int[a][a];
    System.out.println("Enter the elements of matrix:");
    for(int i=0;i<a;i++){
      for(int j=0;j<a;j++){
        pcost[i][j]=sc.nextInt();
      }
    }
    primsOT(pcost,a);
  }
}
