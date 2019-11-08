package dao;

import beans.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class essaiDAO {

    /* Connexion à la base de données */
    String url = "jdbc:derby://localhost:1527/JEEDB";
    String user = "jee";
    String password = "jee";

    Connection conn = null;
    Statement statement = null;
    ResultSet resultat = null;

    public List<Employee> getEmployeesSTP() throws ClassNotFoundException {
        Employee employee = null;
        List<Employee> employees = new ArrayList<Employee>();

        try {
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();
            resultat = statement.executeQuery("SELECT ID, NAME, FIRSTNAME, TELHOME, TELMOB, TELPRO, ADDRESS, POSTALCODE, CITY, EMAIL, LOGIN, PASSWORD, STATUS FROM EMPLOYEES");

            while (resultat.next()) {
//                int id = Integer.parseInt(resultat.getString("ID"));
//                String name = resultat.getString("NAME");
//                String firstName = resultat.getString("FIRSTNAME");
//                String telHome = resultat.getString("TELHOME");
//                String telMob = resultat.getString("TELMOB");
//                String telPro = resultat.getString("TELPRO");
//                String address = resultat.getString("ADRESS");
//                String postalCode = resultat.getString("POSTALCODE");
//                String city = resultat.getString("CITY");
//                String email = resultat.getString("EMAIL");
//                String login = resultat.getString("LOGIN");
//                String password = resultat.getString("PASSWORD");
//                String status = resultat.getString("STATUS");

                int id = Integer.parseInt(resultat.getString(0));
                String name = resultat.getString(1);
                String firstName = resultat.getString(2);
                String telHome = resultat.getString(3);
                String telMob = resultat.getString(4);
                String telPro = resultat.getString(5);
                String address = resultat.getString(6);
                String postalCode = resultat.getString(7);
                String city = resultat.getString(8);
                String email = resultat.getString(9);
                String login = resultat.getString(10);
                String password = resultat.getString(11);
                String status = resultat.getString(12);

                employee = new Employee(id, name, firstName, telHome, telMob, telPro, address, postalCode, city, email);
                employee.setLogin(login);
                employee.setPassword(password);
                employee.setStatus(status);
                
                employees.add(employee);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        return employees;
    }
}
