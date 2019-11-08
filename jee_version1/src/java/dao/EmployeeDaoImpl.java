//package dao;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import beans.Employee;
//
//public class EmployeeDaoImpl implements EmployeeDao {
//    private DaoFactory daoFactory;
//
//    EmployeeDaoImpl(DaoFactory daoFactory) {
//        this.daoFactory = daoFactory;
//    }
//
//    @Override
//    public List<Employee> getEmployees() {
//        Employee employee = null;
//        List<Employee> employees = new ArrayList<Employee>();
//        Connection connexion = null;
//        Statement statement = null;
//        ResultSet resultat = null;
//
//        try {
//            connexion = daoFactory.getConnection();
//            statement = connexion.createStatement();
//            resultat = statement.executeQuery("SELECT ID, \"NAME\", FIRSTNAME, TELHOME, TELMOB, TELPRO, ADRESS, POSTALCODE, CITY, EMAIL, LOGIN, PASSWORD, STATUS FROM EMPLOYEES;");
//
//            while (resultat.next()) {                
//                int id = resultat.getInt("ID");
//                String name = resultat.getString("\"NAME\"");
//                String firstName = resultat.getString("FIRSTNAME");
//                String teleHome = resultat.getString("TELHOME");
//                String telMob = resultat.getString("TELMOB");
//                String telPro = resultat.getString("TELPRO");
//                String address = resultat.getString("ADRESS");
//                String postalCode = resultat.getString("POSTALCODE");
//                String city = resultat.getString("CITY");
//                String email = resultat.getString("EMAIL");
//                String login = resultat.getString("LOGIN");
//                String password = resultat.getString("PASSWORD");
//                String status = resultat.getString("STATUS");
//
//                employee = new Employee(id, name, firstName, teleHome, telMob, telPro, address, postalCode, city, email, login, password, status);
//
//                employees.add(employee);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }
//
//}