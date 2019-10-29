package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
    private DaoFactory daoFactory;

    EmployeeDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * from EMPLOYEES;");

            while (resultat.next()) {                
                int id = resultat.getInt("id");
                String name = resultat.getString("name");
                String firstName = resultat.getString("firstName");
                String teleHome = resultat.getString("teleHome");
                String telMob = resultat.getString("telMob");
                String telPro = resultat.getString("telPro");
                String address = resultat.getString("address");
                String postalCode = resultat.getString("postalCode");
                String city = resultat.getString("city");
                String email = resultat.getString("email");
                String login = resultat.getString("login");
                String password = resultat.getString("password");
                String status = resultat.getString("status");
                System.out.println(firstName);

                Employee employee = new Employee(id, name, firstName, teleHome, telMob, telPro, address, postalCode, city, email, login, password, status);

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

}