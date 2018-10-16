/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vasil
 */
@WebServlet(name = "SimpleServlet", urlPatterns = {"/simple"})
public class SimpleServlet extends HttpServlet {

    private EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        System.out.println("is new = " + session.isNew());

        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet jhgjh jhg jhgkjhgkjhgjhgNewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fdhsfdhsfhdfgh dfghNewServlet at " + request.getContextPath() + "</h1>");
            out.println("<br>session = " + session.getId() + "<br>");
            try {
                out.println("<br>old_date = " + session.getAttribute("date").toString() + "<br>");
            } catch (Exception e) {
                out.println("<br>Error old_date = " + e.getMessage() + "<br>");
            }
            session.setAttribute("date", new Date());
            out.println("<br>new_date = " + session.getAttribute("date").toString() + "<br>");

            em = Main.getEM();

            TypedQuery<TUsers> query = em.createNamedQuery("TUsers.findAll", TUsers.class);
            List<TUsers> usersList = query.getResultList();
            usersList.forEach((t) -> {
                out.println("user = " + t.toString() + "<br>");
            });
            out.println("</body>");
            out.println("</html>");
        }
        System.out.println("session close");

        session.invalidate();
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            cookie.setMaxAge(0);
//            cookie.setValue(null);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
