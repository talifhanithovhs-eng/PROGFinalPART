package progassignment;

import java.util.Scanner;
import java.util.ArrayList;

public class QuickChat {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Message> sentMessages = new ArrayList<>();
    private ArrayList<Message> disregardedMessages = new ArrayList<>();
    private ArrayList<Message> storedMessages = new ArrayList<>();
    private ArrayList<String> messageHashes = new ArrayList<>();
    private ArrayList<Integer> messageIDs = new ArrayList<>();

    public void startChat() {
        System.out.println("Welcome to QuickChat!");
        initializeTestData(); // Populate with test data

        boolean running = true;
        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Display Task Report");
            System.out.println("4) Quit");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    sendMessages();
                    break;
                case 2:
                    showRecentMessages();
                    break;
                case 3:
                    displayTaskReport();
                    break;
                case 4:
                    System.out.println("Exiting QuickChat. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void initializeTestData() {
        // Test Data Message 1
        Message msg1 = new Message("+277854957989", "Did you get the cake?", "Sent");
        addToArrays(msg1);

        // Test Data Message 2
        Message msg2 = new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        addToArrays(msg2);

        // Test Data Message 3
        Message msg3 = new Message("+27884484567", "Yohoooo, I am at your gate.", "Disregard");
        addToArrays(msg3);

        // Test Data Message 4
        Message msg4 = new Message("0838884567", "It is dinner time!", "Sent");
        addToArrays(msg4);

        // Test Data Message 5
        Message msg5 = new Message("+27838884567", "Ok, I am leaving without you.", "Stored");
        addToArrays(msg5);

        System.out.println("Test data initialized successfully!");
    }

    private void addToArrays(Message message) {
        messageHashes.add(message.getMessageHash());
        messageIDs.add(message.getMessageID());
        
        switch (message.getFlag()) {
            case "Sent":
                sentMessages.add(message);
                break;
            case "Disregard":
                disregardedMessages.add(message);
                break;
            case "Stored":
                storedMessages.add(message);
                break;
        }
    }

    private void sendMessages() {
        System.out.println("How many messages would you like to send?");
        int numMessages = input.nextInt();
        input.nextLine(); // consume newline

        for (int i = 0; i < numMessages; i++) {
            System.out.println("Enter recipient phone number:");
            String recipient = input.nextLine();

            System.out.println("Enter message:");
            String messageText = input.nextLine();

            Message msg = new Message();
            msg.sendMessage(recipient, messageText);
            addToArrays(msg);
        }
        System.out.println("\nTotal messages sent: " + Message.getTotalMessages());
    }

    private void showRecentMessages() {
        System.out.println("\n=== Recently Sent Messages ===");
        for (Message msg : sentMessages) {
            msg.displayMessage();
            System.out.println("-----------------------------");
        }
    }

    private void displayTaskReport() {
        boolean inReportMenu = true;
        while (inReportMenu) {
            System.out.println("\n=== Task Report Menu ===");
            System.out.println("1) Display sender and recipient of all sent messages");
            System.out.println("2) Display the longest sent message");
            System.out.println("3) Search for message by ID");
            System.out.println("4) Search messages by recipient");
            System.out.println("5) Delete message by hash");
            System.out.println("6) Display full report of all sent messages");
            System.out.println("7) Return to main menu");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displaySendersAndRecipients();
                    break;
                case 2:
                    displayLongestMessage();
                    break;
                case 3:
                    searchByMessageID();
                    break;
                case 4:
                    searchByRecipient();
                    break;
                case 5:
                    deleteByHash();
                    break;
                case 6:
                    displayFullReport();
                    break;
                case 7:
                    inReportMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void displaySendersAndRecipients() {
        System.out.println("\n=== Senders and Recipients of Sent Messages ===");
        for (Message msg : sentMessages) {
            System.out.println("Recipient: " + msg.getRecipient() + " | Message: " + 
                (msg.getMessageText().length() > 30 ? 
                 msg.getMessageText().substring(0, 30) + "..." : msg.getMessageText()));
        }
    }

    private void displayLongestMessage() {
        if (sentMessages.isEmpty()) {
            System.out.println("No sent messages found.");
            return;
        }

        Message longest = sentMessages.get(0);
        for (Message msg : sentMessages) {
            if (msg.getMessageText().length() > longest.getMessageText().length()) {
                longest = msg;
            }
        }
        
        System.out.println("\n=== Longest Sent Message ===");
        System.out.println("Length: " + longest.getMessageText().length() + " characters");
        System.out.println("Message: " + longest.getMessageText());
        System.out.println("Recipient: " + longest.getRecipient());
    }

    private void searchByMessageID() {
        System.out.println("Enter Message ID to search:");
        int searchID = input.nextInt();
        input.nextLine(); // consume newline

        for (Message msg : sentMessages) {
            if (msg.getMessageID() == searchID) {
                System.out.println("\n=== Message Found ===");
                System.out.println("Recipient: " + msg.getRecipient());
                System.out.println("Message: " + msg.getMessageText());
                return;
            }
        }
        System.out.println("Message with ID " + searchID + " not found in sent messages.");
    }

    private void searchByRecipient() {
        System.out.println("Enter recipient phone number to search:");
        String recipient = input.nextLine();

        System.out.println("\n=== Messages for " + recipient + " ===");
        boolean found = false;
        
        // Search in sent messages
        for (Message msg : sentMessages) {
            if (msg.getRecipient().equals(recipient)) {
                System.out.println("✓ SENT: " + msg.getMessageText());
                found = true;
            }
        }
        
        // Search in stored messages
        for (Message msg : storedMessages) {
            if (msg.getRecipient().equals(recipient)) {
                System.out.println("✓ STORED: " + msg.getMessageText());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No messages found for recipient: " + recipient);
        }
    }

    private void deleteByHash() {
        System.out.println("Enter Message Hash to delete:");
        String hash = input.nextLine();

        // Search and remove from all arrays
        Message toRemove = null;
        
        for (Message msg : sentMessages) {
            if (msg.getMessageHash().equals(hash)) {
                toRemove = msg;
                break;
            }
        }
        
        if (toRemove != null) {
            sentMessages.remove(toRemove);
            messageHashes.remove(toRemove.getMessageHash());
            messageIDs.remove((Integer)toRemove.getMessageID());
            System.out.println("Message '" + toRemove.getMessageText() + "' successfully deleted.");
        } else {
            System.out.println("Message with hash " + hash + " not found.");
        }
    }

    private void displayFullReport() {
        System.out.println("\n=== FULL MESSAGE REPORT ===");
        System.out.printf("%-20s %-15s %-50s %-10s\n", "Message Hash", "Recipient", "Message", "Flag");
        System.out.println("---------------------------------------------------------------------------------------------------");
        
        // Display sent messages
        for (Message msg : sentMessages) {
            String shortMessage = msg.getMessageText().length() > 45 ? 
                msg.getMessageText().substring(0, 45) + "..." : msg.getMessageText();
            System.out.printf("%-20s %-15s %-50s %-10s\n", 
                msg.getMessageHash(), msg.getRecipient(), shortMessage, msg.getFlag());
        }
        
        // Display stored messages
        for (Message msg : storedMessages) {
            String shortMessage = msg.getMessageText().length() > 45 ? 
                msg.getMessageText().substring(0, 45) + "..." : msg.getMessageText();
            System.out.printf("%-20s %-15s %-50s %-10s\n", 
                msg.getMessageHash(), msg.getRecipient(), shortMessage, msg.getFlag());
        }
        
        // Display disregarded messages
        for (Message msg : disregardedMessages) {
            String shortMessage = msg.getMessageText().length() > 45 ? 
                msg.getMessageText().substring(0, 45) + "..." : msg.getMessageText();
            System.out.printf("%-20s %-15s %-50s %-10s\n", 
                msg.getMessageHash(), msg.getRecipient(), shortMessage, msg.getFlag());
        }
        
        System.out.println("\n=== SUMMARY ===");
        System.out.println("Total Sent Messages: " + sentMessages.size());
        System.out.println("Total Stored Messages: " + storedMessages.size());
        System.out.println("Total Disregarded Messages: " + disregardedMessages.size());
        System.out.println("Total All Messages: " + (sentMessages.size() + storedMessages.size() + disregardedMessages.size()));
    }
}