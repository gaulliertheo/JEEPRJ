/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import beans.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesListServlet extends HttpServlet {

//    private EmployeeDao employeeDao;
    private essaiDAO lEssaiDAO;

    public void init() throws ServletException {
//        DaoFactory daoFactory = new DaoFactory();
//        this.employeeDao = daoFactory.getEmployeeDao();
        lEssaiDAO = new essaiDAO();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employees = null;
        try {
            employees = lEssaiDAO.getEmployeesSTP();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeesListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//        List<Employee> employees = new ArrayList<Employee>();
//        try (PrintWriter out = response.getWriter()) {
//                out.println("<p> Es-tu vide : " + employees.isEmpty()+ "<p>");
//            }
//        request.setAttribute("employees", employees);

        Employee employee1 = new Employee(1, "name1", "firstName", "teleHome", "telMob", "telPro", "address", "postalCode", "city", "mail");
        Employee employee2 = new Employee(2, "name2", "firstName", "teleHome", "telMob", "telPro", "address", "postalCode", "city", "mail");
        Employee employee3 = new Employee(3, "name3", "firstName", "teleHome", "telMob", "telPro", "address", "postalCode", "city", "mail");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        request.setAttribute("employees", employees);
        this.getServletContext().getRequestDispatcher("/WEB-INF/employeesList.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        List<Employee> employees = null;
        try {
            employees = lEssaiDAO.getEmployeesSTP();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeesListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (action) {
            case "Add":
            case "Delete":
                
                int id = Integer.parseInt(request.getParameter("inputId"));
                try (PrintWriter out = response.getWriter()) {
                    out.println("<p>" + id + "<p>");
                    out.println("<p>" + action + "<p>");

                }
            default:
                
                Employee employee1 = new Employee(1, "name1", "firstName", "teleHome", "telMob", "telPro", "address", "postalCode", "city", "mail");
                Employee employee2 = new Employee(2, "name2", "firstName", "teleHome", "telMob", "telPro", "address", "postalCode", "city", "mail");
                Employee employee3 = new Employee(3, "name3", "firstName", "teleHome", "telMob", "telPro", "address", "postalCode", "city", "mail");

                employees.add(employee1);
                employees.add(employee2);
                employees.add(employee3);

                request.setAttribute("employees", employees);
                this.getServletContext().getRequestDispatcher("/WEB-INF/employeesList.jsp").forward(request, response);
                break;
        }

//        request.setAttribute("employee", employee);
//        this.getServletContext().getRequestDispatcher("/WEB-INF/emloyeeDetails.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
