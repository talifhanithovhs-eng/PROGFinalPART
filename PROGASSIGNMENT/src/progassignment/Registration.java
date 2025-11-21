package progassignment;

import java.util.Scanner;

public class Registration {
    Scanner usrInput = new Scanner(System.in);
    String RegUsername;
    String name;
    String surname;
    String RegPassword;
    String cellphoneNum;

    public void collectInfo() {
        // Name
        System.out.println("Please enter your name");
        name = usrInput.nextLine();
        
        // Surname
        System.out.println("Please enter your surname");
        surname = usrInput.nextLine();
        
        // Username
        do {
            System.out.println("Please enter your user name");
            RegUsername = usrInput.nextLine();
        } while (!checkUsername(RegUsername));
        
        // Password
        do {
            System.out.println("Please enter a password");
            RegPassword = usrInput.nextLine();
        } while (!checkPassword(RegPassword));
        
        // Cell number
        do {
            System.out.println("Please enter your phone number");
            cellphoneNum = usrInput.nextLine();
        } while (!checkCellNumber(cellphoneNum));

        // Login and QuickChat
        Login login = new Login(this);
        System.out.println(login.returnLoginStatus(RegUsername, RegPassword));

        if (login.loginUser(RegUsername, RegPassword)) {
            System.out.println("User has successfully logged in!");
            QuickChat chat = new QuickChat();
            chat.startChat();
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }

    private boolean checkUsername(String username) {
        // Add username validation logic
        return true;
    }

    private boolean checkPassword(String password) {
        // Add password validation logic
        return true;
    }

    private boolean checkCellNumber(String cellNumber) {
        // Add cell number validation logic
        return true;
    }
}