//Name:-Vaishnavi Satish Deore
//Roll no.:-133 Div:-B Batch:-S3B
//Program of implementation of Prims algorithm.

import java.util.Arrays;
import java.util.Scanner;
public class Prims {

   static void primsOT(int pcost[][],int a)
   {
   int mincost=0;
   int edgecount=1;
   boolean[] visited=new boolean[a];
        Arrays.fill(visited,false);
        visited[0]=true;
        while(edgecount<a){
            int min=99;
            int X=0,Y=0;
        for(int i=0;i<a;i++){
            if(visited[i]==true){
                for(int j=0;j<a;j++){
                    if(visited[j]!=true&&min>pcost[i][j]){
                        min=pcost[i][j];
                        X=i;
                        Y=j;
                    }
                }
            }
        }
            visited[Y]=true;
            System.out.println("Edgecount "+edgecount++ +"min cost is"+ " "+ X+" "+Y+" "+min);
            mincost=mincost+pcost[X][Y];

    }
        System.out.println("Minimum cost of spanning tree is"+mincost);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the number of vertex");
        int a = s.nextInt();
        int pcost[][] = new int[a][a];
        System.out.println("Enter the element of matrix INF=(99)");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                pcost[i][j] = s.nextInt();
            }
        }
        primsOT(pcost,a);
    }
}