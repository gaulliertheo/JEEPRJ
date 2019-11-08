//package dao;
//
//import beans.Employee;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class DaoFactory {
//    
//
//    /* Connexion à la base de données */
//    String url;
//    String user;
//    String password;
//    Connection conn = null;
//    
//    public DaoFactory() {
//        this.url = "jdbc:derby://localhost:1527/JEEDB";
//        this.user = "jee";
//        this.password = "jee";
//    }
//    
//    public Connection getConnection() {
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//
//        } finally {
//            if (conn != null) {
//                try {
//                    /* Fermeture de la conn */
//                    conn.close();
//                } catch (SQLException ignore) {
//
//                }
//            }
//        }
//        return conn;
//    }
//    
////     Récupération du Dao
//    public EmployeeDao getEmployeeDao() {
//        return new EmployeeDaoImpl(this);
//    }
//    
////    private String url;
////    private String username;
////    private String password;
////
////    DaoFactory(String url, String username, String password) {
////        this.url = url;
////        this.username = username;
////        this.password = password;
////    }
////
////    public static DaoFactory getInstance() {
////        try {
////            Class.forName("com.mysql.jdbc.Driver");
////        } catch (ClassNotFoundException e) {
////
////        }
////
////        DaoFactory instance = new DaoFactory(
////                "jdbc:derby://localhost:1527/JEEDB", "jee", "jee");
////        return instance;
////    }
////
////    public Connection getConnection() throws SQLException {
////        return DriverManager.getConnection(url, username, password);
////    }
////
////    // Récupération du Dao
////    public EmployeeDao getEmployeeDao() {
////        return new EmployeeDaoImpl(this);
////    }
//}
