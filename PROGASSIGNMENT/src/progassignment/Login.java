package progassignment;

public class Login {
    private Registration register;

    public Login(Registration register) {
        this.register = register;
    }

    public boolean loginUser(String username, String password) {
        return register.RegUsername.equals(username) && register.RegPassword.equals(password);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + register.name + " " + register.surname + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}