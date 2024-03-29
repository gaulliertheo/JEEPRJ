package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import package1.*;

public class Controller extends HttpServlet {

    @EJB
    private EmployeeSB employeeSB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String action = request.getParameter("action");

        String inputName, inputFirstName, inputTelHome, inputTelMob, inputTelPro, inputAddress, inputPostalCode, inputCity, inputEmail, login, psw;
        int id;

        /* Every jsp's buttons have a name="action" with his OWN value that will match with one of the cases in the switch bellow */
        switch (action) {
            case "Login":
                login = request.getParameter("inputLogin");
                psw = request.getParameter("inputPassword");
                String erreur = null;
                if (login.equals("") || psw.equals("")) {
                    erreur = "You must enter values in both fields.";
                    request.setAttribute("erreur", erreur);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }
                Employees user = employeeSB.login_check(login, psw);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    postEmployees(request, response);
                } else {
                    erreur = "Connection failed! Verify you login/password and try again.";
                    request.setAttribute("erreur", erreur);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }
                break;

            case "Detail":
                id = Integer.parseInt(request.getParameter("inputId"));
                Employees employee = null;
                try {
                    employee = employeeSB.getAnEmployee(id);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("employee", employee);
                this.getServletContext().getRequestDispatcher("/WEB-INF/employeeDetails.jsp").forward(request, response);
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
                    employeeSB.modifyAnEmployee(id, inputName, inputFirstName, inputTelHome, inputTelMob, inputTelPro, inputAddress, inputPostalCode, inputCity, inputEmail);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                postEmployees(request, response);
                break;

            case "Delete":
                id = Integer.parseInt(request.getParameter("inputId"));
                employeeSB.deleteAnEmployee(id);
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
                    employeeSB.addAnEmployee(inputName, inputFirstName, inputTelHome, inputTelMob, inputTelPro, inputAddress, inputPostalCode, inputCity, inputEmail);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                postEmployees(request, response);
                break;

            case "Logout":
                request.getSession().invalidate();
                this.getServletContext().getRequestDispatcher("/WEB-INF/logout.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /* Get all employees and post them in the employeesList.jsp */
    public void postEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Employees> ListOfEmployees = new ArrayList<>();
        ListOfEmployees.addAll(employeeSB.getEmployees());

        request.setAttribute("employees", ListOfEmployees);
        this.getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
    }
}
