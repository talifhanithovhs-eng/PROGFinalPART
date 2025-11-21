package progassignment;

import java.util.Random;

public class Message {
    private static int totalMessages = 0;
    private int messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String flag; // "Sent", "Stored", or "Disregard"

    public Message() {
        this.messageID = new Random().nextInt(900000000) + 100000000;
        totalMessages++;
    }

    public Message(String recipient, String messageText, String flag) {
        this();
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
        createMessageHash();
    }

    public void sendMessage(String recipient, String messageText) {
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = "Sent";
        
        if (messageText.length() > 250) {
            System.out.println("Please enter a message of less than 250 characters.");
            return;
        } else {
            System.out.println("Message sent!");
        }

        createMessageHash();
        displayMessage();
    }

    public void createMessageHash() {
        String[] words = messageText.split(" ");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 0 ? words[words.length - 1] : "";
        this.messageHash = (messageID + ":" + totalMessages + ":" + firstWord + lastWord).toUpperCase();
    }

    public void displayMessage() {
        System.out.println("\nMessage Details:");
        System.out.println("Message ID: " + messageID);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageText);
        System.out.println("Message Hash: " + messageHash);
        System.out.println("Flag: " + flag);
        System.out.println("Total Messages: " + totalMessages);
    }

    // Getters
    public static int getTotalMessages() { return totalMessages; }
    public int getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public String getFlag() { return flag; }
    
    // Setters
    public void setFlag(String flag) { this.flag = flag; }
}