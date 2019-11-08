/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gaull
 */
public class EmployeeDetailsServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeDetailsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeDetailsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        Employee employee = new Employee(1, "name1", "firstName", "teleHome", "telMob", "telPro", "address", "postalCode", "city", "mail");
        request.setAttribute("employee", employee);
        this.getServletContext().getRequestDispatcher("/WEB-INF/employeeDetails.jsp").forward(request, response);
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

//        if (!action.equals("Cancel")) {
//            int id = Integer.parseInt(action);
//            String name = request.getParameter("inputName");
//            String firstName = request.getParameter("inputFirstName");
//            String telHome = request.getParameter("inputHomePhone");
//            String telMob = request.getParameter("inputMobilePhone");
//            String telPro = request.getParameter("inputWorkPhone");
//            String address = request.getParameter("inputAddress");
//            String postalCode = request.getParameter("inputPostalCode");
//            String city = request.getParameter("inputCity");
//            String email = request.getParameter("inputEmail");
//
//            try (PrintWriter out = response.getWriter()) {
//                /* TODO output your page here. You may use following sample code. */
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet EmployeeDetailsServlet</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<p>" + id + "</p>");
//                out.println("<p>" + name + "</p>");
//                out.println("<p>" + firstName + "</p>");
//                out.println("<p>" + telHome + "</p>");
//                out.println("<p>" + telMob + "</p>");
//                out.println("<p>" + telPro + "</p>");
//                out.println("<p>" + address + "</p>");
//                out.println("<p>" + postalCode + "</p>");
//                out.println("<p>" + city + "</p>");
//                out.println("<p>" + email + "</p>");
//                out.println("</body>");
//                out.println("</html>");
//            }
//        }else 
        if (action.equals("Detail")){
            int idDeList = Integer.parseInt(request.getParameter("inputId"));
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EmployeeDetailsServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>" + idDeList + "</p>");
                out.println("</body>");
                out.println("</html>");
            }
        }
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
