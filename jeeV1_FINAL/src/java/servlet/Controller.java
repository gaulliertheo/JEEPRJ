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

public class Controller extends HttpServlet {

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
        if (request.getSession().getAttribute("user") != null){
            postEmployees(request, response);
        }else{
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String inputName, inputFirstName, inputTelHome, inputTelMob, inputTelPro, inputAddress, inputPostalCode, inputCity, inputEmail, login, psw;
        int id;

        /* Every jsp's buttons have a name="action" with his OWN value that will match with one of the cases in the switch bellow */
        switch (action) {
            case "Login":
                login = request.getParameter("inputLogin");
                psw = request.getParameter("inputPassword");
                String erreur = null;
                try {
                    if (login.equals("") || psw.equals("")) {
                        erreur = "You must enter values in both fields.";
                        request.setAttribute("erreur", erreur);
                        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                    }
                    Employee user = db.login_check(login, psw);
                    HttpSession maSession = request.getSession();
                    maSession.setAttribute("user", user);
                    postEmployees(request, response);
                } catch (Exception e) {
                    erreur = "Connection failed! Verify you login/password and try again.";
                    request.setAttribute("erreur", erreur);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }

                break;

            case "Logout":
                request.getSession().invalidate();
                this.getServletContext().getRequestDispatcher("/WEB-INF/logout.jsp").forward(request, response);
                break;

            case "Modify":
                id = Integer.parseInt(request.getParameter("id"));
                inputName = request.getParameter("inputName");
                inputFirstName = request.getParameter("inputFirstName");
                inputTelHome = request.getParameter("inputHomePhone");
                inputTelMob = request.getParameter("inputMobilePhone");
                inputTelPro = request.getParameter("inputWorkPhone");
                inputAddress = request.getParameter("inputAddress");
                inputPostalCode = request.getParameter("inputPostalCode");
                inputCity = request.getParameter("inputCity");
                inputEmail = request.getParameter("inputEmail");
                try {
                    db.modifyAnEmployee(id, inputName, inputFirstName, inputTelHome, inputTelMob, inputTelPro, inputAddress, inputPostalCode, inputCity, inputEmail);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                postEmployees(request, response);
                break;

            case "Detail":
                id = Integer.parseInt(request.getParameter("inputId"));
                Employee employee = null;
                try {
                    employee = db.getAnEmployee(id);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("employee", employee);
                this.getServletContext().getRequestDispatcher("/WEB-INF/employeeDetails.jsp").forward(request, response);
                break;

            case "Delete":
                id = Integer.parseInt(request.getParameter("inputId"));
                try {
                    db.deleteAnEmployee(id);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                postEmployees(request, response);
                break;

            case "AddEmployee":
                this.getServletContext().getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(request, response);
                break;

            case "Add":
                inputName = request.getParameter("inputName");
                inputFirstName = request.getParameter("inputFirstName");
                inputTelHome = request.getParameter("inputHomePhone");
                inputTelMob = request.getParameter("inputMobilePhone");
                inputTelPro = request.getParameter("inputWorkPhone");
                inputAddress = request.getParameter("inputAddress");
                inputPostalCode = request.getParameter("inputPostalCode");
                inputCity = request.getParameter("inputCity");
                inputEmail = request.getParameter("inputEmail");
                try {
                    db.addAnEmployee(inputName, inputFirstName, inputTelHome, inputTelMob, inputTelPro, inputAddress, inputPostalCode, inputCity, inputEmail);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                postEmployees(request, response);
                break;

            case "NewLogin":
                this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                break;

            case "Cancel":
                postEmployees(request, response);
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    /* Get all employees and post them in the employeesList.jsp */
    protected void postEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = db.getEmployees();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("employees", employees);
        this.getServletContext().getRequestDispatcher("/WEB-INF/employeesList.jsp").forward(request, response);
    }
}
