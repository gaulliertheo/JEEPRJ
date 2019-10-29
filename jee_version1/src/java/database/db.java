package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import beans.Employee;
 
/**
 *
 * @author JAA
 */
public class db {
 
    public static final String URL = "jdbc:derby://localhost:1527/JEEDB";
    public static final String USER = "jee";
    public static final String PWD = "jee";
    public static final String SEL_QUERY = "SELECT * from EMPLOYEES";
    boolean test = false;
    boolean Empty = false;
   
   
   
    Connection conn;
    Statement stmt;
    ResultSet rs;
 
    public db() {
        try {
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
 
    public Statement getStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return stmt;
 
    }
 
    public ResultSet getResultSet() {
        stmt = getStatement();
        try {
            rs = stmt.executeQuery(SEL_QUERY);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return rs;
 
    }
 
//    public ArrayList<User> getUsers() {
//        listUsers = new ArrayList<>();
//        rs = getResultSet();
//        try {
//            while (rs.next()) {
//                User userBean = new User();
//                userBean.setLogin(rs.getString("EMAIL"));
//                userBean.setPwd(rs.getString("PWD"));
//                userBean.setFirstName(rs.getString("FIRSTNAME"));
//                userBean.setName(rs.getString("NAME"));
//                userBean.setTelHome(rs.getString("TELHOME"));
//                userBean.setTelMob(rs.getString("TELMOB"));
//                userBean.setTelPro(rs.getString("TELPRO"));
//                userBean.setAdress(rs.getString("ADRESS"));
//                userBean.setPostalCode(rs.getString("POSTALCODE"));  
//                userBean.setCity(rs.getString("CITY"));  
//               
//                listUsers.add(userBean);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return listUsers;
//    }
// 
//    public boolean checkCredentials(User userInput) {
//        listUsers = getUsers();
// 
//        for (User userBase : listUsers) {
//            if (userBase.getLogin().equals(userInput.getLogin())
//                    && userBase.getPwd().equals(userInput.getPwd())) {
//               
//               userInput.setName(userBase.getName());
//               userInput.setFirstName(userBase.getFirstName());
//               
//               
//                return true;
//            }
//        }
//        return false;
//    }
//   
//     public boolean checkIfEmpty(User userInput) {
//       
//            if ( userInput.getLogin().isEmpty() || userInput.getPwd().isEmpty() ) {
//               
//                return true;
//            }
//       
//        return false;
//    }
// 
}
