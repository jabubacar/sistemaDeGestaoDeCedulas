/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.FuncionarioAdminJpaController;
import controller.FuncionarioNormalJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.FuncionarioAdmin;
import modelo.FuncionarioNormal;

/**
 *
 * @author Jozino M. Abubacar
 */
public class Validacao extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validacao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validacao at " + request.getContextPath() + "</h1>");
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
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CedulaPU");
                
                
                

        FuncionarioNormalJpaController fc = new FuncionarioNormalJpaController(emf);
        FuncionarioAdminJpaController fa = new FuncionarioAdminJpaController(emf);
        PrintWriter out = response.getWriter();
        boolean eFuncionarioNormal = false;
        boolean senhaCombina = false;
        boolean eFuncionarioAdmin = false;
        boolean senhaCombinaAdmin = false;
        // List<FuncionarioNormal> lista = fc.findFuncionarioNormalEntities();
        String username = request.getParameter("username");

        String senha = request.getParameter("senha");

       /* System.out.println("username: " + username + " senha: " + senha);
        out.println("<p> Nome usuario enviado " + username + "</p>");
        out.println("<p> Senha do usuario enviado " + senha + "</p>");*/

        for (FuncionarioNormal funcionarioNormal : fc.findFuncionarioNormalEntities()) {
            if (funcionarioNormal.getNomeUsuario().equalsIgnoreCase(username)) {
                eFuncionarioNormal = true;
                if (funcionarioNormal.getSenha().equals(senha)) {

                    senhaCombina = true;
                }
                break;
            }
//
//            out.println("<p> Nome usuario " + funcionarioNormal.getNomeUsuario() + "</p>");
//            out.println("<p> Senha " + funcionarioNormal.getSenha() + "</p>");
        }

        for (FuncionarioAdmin funcionarioAdmin : fa.findFuncionarioAdminEntities()) {
            if (funcionarioAdmin.getNomeUsuario().equalsIgnoreCase(username)) {
                eFuncionarioAdmin = true;
                if (funcionarioAdmin.getSenha().equals(senha)) {
                    senhaCombinaAdmin = true;
                }
                break;
            }
        }
        if (eFuncionarioNormal && senhaCombina) {
            RequestDispatcher view = request.getRequestDispatcher("funcionario.jsp");
            view.forward(request, response);
        } else {
            if (eFuncionarioAdmin && senhaCombinaAdmin) {
                RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("mensagem", "Utilizador nao cadastrado ou Dados de Login incorretos");
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            }
        }

        /**
         * Returns a short description of the servlet.
         *
         *
         *
         * @return a String containing servlet description
         */
//         @Override
//    public String getServletInfo(){
//        return "Short description";
//            }// </editor-fold>
//         
    }
}
