import java.util.Arrays;
import java.util.Scanner;

public class SocialNetwork {

    static void connectUsers(int[][] connectionCost, int numUsers) {
        int minConnectionCost = 0;
        int connectionCount = 1;
        boolean[] connected = new boolean[numUsers];
        Arrays.fill(connected, false);
        
        connected[0] = true;
        
        while (connectionCount < numUsers) {
            int minCost = Integer.MAX_VALUE;
            int userA = 0, userB = 0;
            
            for (int i = 0; i < numUsers; i++) {
                if (connected[i]) {
                    for (int j = 0; j < numUsers; j++) {
                        if (!connected[j] && connectionCost[i][j] < minCost) {
                            minCost = connectionCost[i][j];
                            userA = i;
                            userB = j;
                        }
                    }
                }
            }
            
            connected[userB] = true;
            System.out.println("Connection " + connectionCount++ + ": User " + userA + " -> User " + userB + " with connection strength " + minCost);
            minConnectionCost += connectionCost[userA][userB];
        }
        
        System.out.println("Minimum connection cost to build the network: " + minConnectionCost);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of users in the network:");
        int numUsers = scanner.nextInt();

        int[][] connectionCost = new int[numUsers][numUsers];
        System.out.println("Enter the connection cost matrix (enter 99 for no direct connection):");

        for (int i = 0; i < numUsers; i++) {
            for (int j = 0; j < numUsers; j++) {
                connectionCost[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nBuilding connections between users...");
        connectUsers(connectionCost, numUsers);

        scanner.close();
    }
}
