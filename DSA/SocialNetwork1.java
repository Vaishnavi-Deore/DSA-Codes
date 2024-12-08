import java.util.*;

public class SocialNetwork1 {

    static void connectUsers(int[][] connectionCost, int numUsers, String[] userNames) {
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
            System.out.println("Connection " + connectionCount++ + ": " + userNames[userA] + " -> " + userNames[userB] + " with connection strength " + minCost);
            minConnectionCost += connectionCost[userA][userB];
        }

        System.out.println("Minimum connection cost to build the network: " + minConnectionCost);
    }

    static void findMutualConnections(int[][] connectionCost, String[] userNames, String user1, String user2) {
        int userIndex1 = -1, userIndex2 = -1;
        
        
        for (int i = 0; i < userNames.length; i++) {
            if (userNames[i].equals(user1)) {
                userIndex1 = i;
            }
            if (userNames[i].equals(user2)) {
                userIndex2 = i;
            }
        }

        if (userIndex1 == -1 || userIndex2 == -1) {
            System.out.println("One or both users not found in the network.");
            return;
        }

        System.out.println("Mutual connections between " + user1 + " and " + user2 + ":");
        boolean mutualFound = false;
        
        for (int i = 0; i < userNames.length; i++) {
            if (i != userIndex1 && i != userIndex2 && connectionCost[userIndex1][i] != 99 && connectionCost[userIndex2][i] != 99) {
                System.out.println(userNames[i]);
                mutualFound = true;
            }
        }

        if (!mutualFound) {
            System.out.println("No mutual connections found between " + user1 + " and " + user2 + ".");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of users in the network:");
        int numUsers = scanner.nextInt();
        scanner.nextLine(); 

        String[] userNames = new String[numUsers];
        System.out.println("Enter the names or IDs of each user:");
        for (int i = 0; i < numUsers; i++) {
            userNames[i] = scanner.nextLine();
        }

        int[][] connectionCost = new int[numUsers][numUsers];
        System.out.println("Enter the connection cost matrix (enter 99 for no direct connection):");
        for (int i = 0; i < numUsers; i++) {
            for (int j = 0; j < numUsers; j++) {
                connectionCost[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nBuilding connections between users...");
        connectUsers(connectionCost, numUsers, userNames);

        scanner.nextLine(); 
        System.out.println("\nEnter the names or IDs of two users to find mutual connections:");
        String user1 = scanner.nextLine();
        String user2 = scanner.nextLine();
        
        findMutualConnections(connectionCost, userNames, user1, user2);

        scanner.close();
    }
}
