/*
Customer and Employee inherit basic attributes from this class
 */

public class User {

    //member variables
    private String username;
    private String password;
    private int phoneNum;
    int userTypeId;


    public User() {
        this.username = "UNKNOWN";
        this.password = "UNKNOWN";
        this.phoneNum = -1;
    }
    //constructor
    public User(String username, String password, int phoneNum, int userTypeId) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        //user type id for determing whether user is customer or employee
        this.userTypeId = userTypeId;
    }

    //get phone num
    public int getPhoneNum() {
        return this.phoneNum;
    }

    //get password
    public String getPassword() {
        return this.password;
    }

    //get username
    public String getUsername() {
        return this.username;
    }

    //set username
    public void setUsername(String username) {
        this.username = username;
    }

    //set password
    public void setPassword(String password) {
        this.password = password;
    }

    //set phone number
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getUserTypeId() {
        return this.userTypeId;
    }

    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}