package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.*;
import beans.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class EmployeesList extends HttpServlet {

    public db db;

    public void init() throws ServletException {
        db = new db();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeesList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeesList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        
        if (action.equals("Login")) {
            String login = request.getParameter("inputLogin");
            String psw = request.getParameter("inputPassword");
            Employee user = db.login_check(login, psw);

            if (user != null) {
                System.out.println("TESTTTTTTTTTTTT");
                HttpSession maSession = request.getSession();
                maSession.setAttribute("user", user);
                List<Employee> employees = new ArrayList<>();
                try {
                    employees = db.getEmployeesSTP();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeesList.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("employees", employees);
                this.getServletContext().getRequestDispatcher("/WEB-INF/employeesList.jsp").forward(request, response);
            } else {
                System.out.println("ERREUR A FAIRE");
            }
        }
        
        if (action.equals("Logout")){
            request.getSession().invalidate();
            this.getServletContext().getRequestDispatcher("/WEB-INF/logout.jsp").forward(request, response);
        }

        if (action.equals("Modify")){ //Function to Modify an Employee
            int id = Integer.parseInt(request.getParameter("id"));
            String inputName = request.getParameter("inputName");
            String inputFirstName = request.getParameter("inputFirstName");
            String inputTelHome = request.getParameter("inputHomePhone");
            String inputTelMob = request.getParameter("inputMobilePhone");
            String inputTelPro = request.getParameter("inputWorkPhone");
            String inputAddress = request.getParameter("inputAddress");
            String inputPostalCode = request.getParameter("inputPostalCode");
            String inputCity = request.getParameter("inputCity");
            String inputEmail = request.getParameter("inputEmail");

            try {
                db.modifyAnEmployee(id, inputName, inputFirstName, inputTelHome, inputTelMob, inputTelPro, inputAddress, inputPostalCode, inputCity, inputEmail);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeesList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (action.equals("Logout")) { //Function to Logout
            System.out.println("TEST");
            request.getSession().invalidate();
            this.getServletContext().getRequestDispatcher("/WEB-INF/logout.jsp").forward(request, response);
        }

        if (action.equals("Detail")) { //Function to see details (redirect to employeeDetails.jsp
            int inputId = Integer.parseInt(request.getParameter("inputId"));
            Employee employee = null;
            try {
                employee = db.getAnEmployee(inputId);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeesList.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("employee", employee);
            this.getServletContext().getRequestDispatcher("/WEB-INF/employeeDetails.jsp").forward(request, response);
        }

        if (action.equals("Delete")) //Function to delete an Employee
        {
            int id = Integer.parseInt(request.getParameter("inputId"));
            try {
                db.deleteAnEmployee(id);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeesList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (action.equals("Add")) { //Function to add an Employee
            String inputName = request.getParameter("inputName");
            String inputFirstName = request.getParameter("inputFirstName");
            String inputTelHome = request.getParameter("inputHomePhone");
            String inputTelMob = request.getParameter("inputMobilePhone");
            String inputTelPro = request.getParameter("inputWorkPhone");
            String inputAddress = request.getParameter("inputAddress");
            String inputPostalCode = request.getParameter("inputPostalCode");
            String inputCity = request.getParameter("inputCity");
            String inputEmail = request.getParameter("inputEmail");

            try {
                db.addAnEmployee(inputName, inputFirstName, inputTelHome, inputTelMob, inputTelPro, inputAddress, inputPostalCode, inputCity, inputEmail);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeesList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (action.equals("AddEmployee")) { //Function to redirect to addEmployee.jsp
            this.getServletContext().getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(request, response);
        }

        List<Employee> employees = new ArrayList<>();
        try {
            employees = db.getEmployeesSTP();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesList.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("employees", employees);
        this.getServletContext().getRequestDispatcher("/WEB-INF/employeesList.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
