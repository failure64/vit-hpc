// Question No: 2
// reportIcon
// Single File Programming Question
// Problem Statement



// Create a circular linked list to simulate a multiplayer game lobby. Each player joining the lobby should be represented as a node in the list, and the list should support operations like adding new players, removing players, and rotating the list to determine the next player's turn.



// Implement the following function.

// addPlayer(String playerName)
// removePlayer(String playerName) 
// rotateList()
// displayPlayers() 
// Input format :
// The input format follows the following details

// Choice 1: Enter 1 and provide the details to add

// Choice 2: Enter 2 to remove a player

// Choice 3:Enter 3 to rotate the list

// Choice 4:Enter 4 to display players

// Choice 5:To exit the program, enter 5

// Note: If the choice is greater than 5 display "Invalid choice. Please try again."

// Output format :
// The output displays as per the given choices.

// Sample test cases :
// Input 1 :
// 1
// track 1
// 1
// track 2
// 4
// 1
// job1
// 1
// job 2
// 2
// job1
// 1
// hh1
// 1
// wew
// 1
// sda
// 3
// 7
// 4
// 5
// Output 1 :
// Player track 1 added to the lobby.
// Player track 2 added to the lobby.
// Players in the lobby: track 1 track 2 
// Player job1 added to the lobby.
// Player job 2 added to the lobby.
// Player job1 removed from the lobby.
// Player hh1 added to the lobby.
// Player wew added to the lobby.
// Player sda added to the lobby.
// Next player's turn: track 2
// Invalid choice. Please try again.
// Players in the lobby: track 2 job 2 hh1 wew sda track 1 




import java.util.Scanner;

// Node class representing a player in the lobby
class PlayerNode {
    String playerName;
    PlayerNode next;

    public PlayerNode(String playerName) {
        this.playerName = playerName;
        this.next = null;
    }
}

// CircularLinkedList class representing the game lobby
class Lobby {
    PlayerNode head;

    // Add a player to the lobby
    public void addPlayer(String playerName) {
        PlayerNode newNode = new PlayerNode(playerName);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            PlayerNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println("Player " + playerName + " added to the lobby.");
    }

    // Remove a player from the lobby
    public void removePlayer(String playerName) {
        if (head == null) {
            System.out.println("The lobby is empty.");
            return;
        }

        PlayerNode curr = head, prev = null;

        // Find the player to remove
        while (curr.next != head && !curr.playerName.equals(playerName)) {
            prev = curr;
            curr = curr.next;
        }

        // If player not found
        if (!curr.playerName.equals(playerName)) {
            System.out.println("Player " + playerName + " is not in the lobby.");
            return;
        }

        // Remove the player from the lobby
        if (curr == head) {
            // If the player to be removed is the head node
            if (head.next == head) {
                // If there is only one player in the lobby
                head = null;
            } else {
                // If there are multiple players in the lobby
                PlayerNode temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
        } else {
            // If the player to be removed is not the head node
            prev.next = curr.next;
        }

        System.out.println("Player " + playerName + " removed from the lobby.");
    }

    // Rotate the list to determine the next player's turn
    public void rotateList() {
        if (head == null) {
            System.out.println("The lobby is empty.");
            return;
        }

        head = head.next;
        System.out.println("Next player's turn: " + head.playerName);
    }

    // Print the players in the lobby
    public void displayPlayers() {
        if (head == null) {
            System.out.println("The lobby is empty.");
            return;
        }

        PlayerNode temp = head;
        System.out.print("Players in the lobby: ");
        do {
            System.out.print(temp.playerName + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lobby lobby = new Lobby();

        while (true) {

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    String playerName = scanner.nextLine();
                    lobby.addPlayer(playerName);
                    break;
                case 2:
                    String playerToRemove = scanner.nextLine();
                    lobby.removePlayer(playerToRemove);
                    break;
                case 3:
                    lobby.rotateList();
                    break;
                case 4:
                    lobby.displayPlayers();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
