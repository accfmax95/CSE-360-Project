public class CreditCard {

    //member variables
    private String name;
    private String date;
    private String number;
    private int cvv;

    //constructor
    public CreditCard(String name, String date, String number, int cvv) {
        this.name = name;
        this.date = date;
        this.number = number;
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    //getter and setter functions for class objects
    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String toString() {
        return "CreditCard{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", number='" + number + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}