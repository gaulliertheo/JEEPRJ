package beans;

public class Employee {
    private int id;
    private String name;
    private String firstName;
    private String teleHome;
    private String telMob;
    private String telPro;
    private String address;
    private String postalCode;
    private String city;
    private String email;
    private String login;
    private String password;
    private String status;

    public Employee(int id, String name, String firstName, String teleHome, String telMob, String telPro, String address, String postalCode, String city, String email, String login, String password, String status) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.teleHome = teleHome;
        this.telMob = telMob;
        this.telPro = telPro;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTeleHome() {
        return teleHome;
    }

    public String getTelMob() {
        return telMob;
    }

    public String getTelPro() {
        return telPro;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setTeleHome(String teleHome) {
        this.teleHome = teleHome;
    }

    public void setTelMob(String telMob) {
        this.telMob = telMob;
    }

    public void setTelPro(String telPro) {
        this.telPro = telPro;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean isAdmin() {
        return (status == "a") ? true : false;
    }
    
    public boolean isEmployee() {
        return (status == "e") ? true : false;
    }
    
}
