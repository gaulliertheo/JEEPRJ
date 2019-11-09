/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maxim
 */
public class db {

    /* Connexion à la base de données */
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

    public ResultSet getResultSet() {
        statement = getStatement();
        try {
            resultat = statement.executeQuery("SELECT * FROM EMPLOYEES");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultat;
    }

    public List<Employee> getEmployeesSTP() throws SQLException {

        resultat = getResultSet();
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
            String status = resultat.getString("STATUT");

            Employee employee = new Employee(id, name, firstName, telHome, telMob, telPro, address, postalCode, city, email);
            employee.setLogin(login);
            employee.setPassword(psw);
            employee.setStatus(status);

            employees.add(employee);
        }
        return employees;
    }
}