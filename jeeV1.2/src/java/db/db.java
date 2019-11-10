package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.Employee;
import java.util.ArrayList;
import java.util.List;

public class db {

    /* Connexion to data base */
    String url = "jdbc:derby://localhost:1527/JEEDB;create=true";
    String user = "jee";
    String password = "jee";

    Connection conn = null;
    Statement statement = null;
    ResultSet resultat = null;

    public db() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            System.out.println("T'ES PAS CO");
        }
    }

    public Statement getStatement() {
        try {
            statement = conn.createStatement();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return statement;
    }

    public ResultSet getResultSet(String query) {
        statement = getStatement();
        try {
            resultat = statement.executeQuery(query);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultat;
    }
    
    public Employee getAnEmployee(int inputId) throws SQLException{
        resultat = getResultSet("SELECT ID, NAME, FIRSTNAME, TELHOME, TELMOB, TELPRO, ADDRESS, POSTALCODE, CITY, EMAIL FROM EMPLOYEES");

        while (resultat.next()) {

            int id = Integer.parseInt(resultat.getString("ID"));
            String name = resultat.getString("NAME");
            String firstName = resultat.getString("FIRSTNAME");
            String telHome = resultat.getString("TELHOME");
            String telMob = resultat.getString("TELMOB");
            String telPro = resultat.getString("TELPRO");
            String address = resultat.getString("ADDRESS");
            String postalCode = resultat.getString("POSTALCODE");
            String city = resultat.getString("CITY");
            String email = resultat.getString("EMAIL");

            if (inputId == id){
                Employee employee = new Employee(id, name, firstName, telHome, telMob, telPro, address, postalCode, city, email);
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getEmployeesSTP() throws SQLException {

        /* Get the employees list from the data base */
        resultat = getResultSet("SELECT * FROM EMPLOYEES");
        List<Employee> employees = new ArrayList<>();
        while (resultat.next()) {

            int id = Integer.parseInt(resultat.getString("ID"));
            String name = resultat.getString("NAME");
            String firstName = resultat.getString("FIRSTNAME");
            String telHome = resultat.getString("TELHOME");
            String telMob = resultat.getString("TELMOB");
            String telPro = resultat.getString("TELPRO");
            String address = resultat.getString("ADDRESS");
            String postalCode = resultat.getString("POSTALCODE");
            String city = resultat.getString("CITY");
            String email = resultat.getString("EMAIL");
            String login = resultat.getString("LOGIN");
            String psw = resultat.getString("PASSWORD");
            String statut = resultat.getString("STATUT");

            Employee employee = new Employee(id, name, firstName, telHome, telMob, telPro, address, postalCode, city, email);
            employee.setLogin(login);
            employee.setPassword(psw);
            employee.setStatut(statut);

            employees.add(employee);
        }
        return employees;
    }

    public Employee login_check(String inputlogin, String inputpsw) {

        String query = "SELECT * FROM EMPLOYEES";
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                int id = Integer.parseInt(resultat.getString("ID"));
                String name = resultat.getString("NAME");
                String firstName = resultat.getString("FIRSTNAME");
                String telHome = resultat.getString("TELHOME");
                String telMob = resultat.getString("TELMOB");
                String telPro = resultat.getString("TELPRO");
                String address = resultat.getString("ADDRESS");
                String postalCode = resultat.getString("POSTALCODE");
                String city = resultat.getString("CITY");
                String email = resultat.getString("EMAIL");
                String login = resultat.getString("LOGIN");
                String psw = resultat.getString("PASSWORD");
                String statut = resultat.getString("STATUT");
                
                if (login.equals(inputlogin) && psw.equals(inputpsw)) {
                    Employee employee = new Employee(id, name, firstName, telHome, telMob, telPro, address, postalCode, city, email);
                    employee.setLogin(login);
                    employee.setPassword(psw);
                    employee.setStatut(statut);
                    return employee;
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public void modifyAnEmployee(int inputId, String name, String firstName, String telHome, String telMob, String telPro, String address, String postalCode, String city, String email) throws SQLException {
        
        String query = "UPDATE EMPLOYEES SET NAME='" + name + "', FIRSTNAME='" + firstName + "', TELHOME='" + telHome + "', TELMOB='" + telMob + "', TELPRO='" + telPro + "', ADDRESS='"
                + address + "', POSTALCODE='" + postalCode + "', CITY='" + city + "', EMAIL='" + email + "' WHERE ID=" + inputId;
        statement = getStatement();
        statement.executeUpdate(query);
    }

    public void addAnEmployee(String name, String firstName, String telHome, String telMob, String telPro, String address, String postalCode, String city, String email) throws SQLException {
        
        String query = "INSERT INTO EMPLOYEES(NAME,FIRSTNAME,TELHOME,TELMOB,TELPRO,ADDRESS,POSTALCODE,CITY,EMAIL) VALUES('" + name+ "', '" + firstName + "', '" + telHome + "', '" + telMob + "', '" + telPro + "', '" + address + "', '" + postalCode + "', '" + city + "', '" + email + "')";
        statement = getStatement();
        statement.executeUpdate(query);
    }
    
    public void deleteAnEmployee(int inputId) throws SQLException{
        
        String query = "DELETE FROM EMPLOYEES WHERE ID=" + inputId;
        statement = getStatement();
        statement.executeUpdate(query);    
    }
}