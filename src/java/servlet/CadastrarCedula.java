/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.CedulasConfirmadasJpaController;
import controller.FuncionarioNormalJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CedulasConfirmadas;
import modelo.FuncionarioNormal;

/**
 *
 * @author Jozino M. Abubacar
 */
@WebServlet(name = "CadastrarCedula", urlPatterns = {"/CadastrarCedula"})
public class CadastrarCedula extends HttpServlet {

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
            out.println("<title>Servlet CadastrarCedula</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarCedula at " + request.getContextPath() + "</h1>");
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
     
                    
    }
//
//            out.println("<p> Nome usuario " + funcionarioNormal.getNomeUsuario() + "</p>");
//            out.println("<p> Senha " + funcionarioNormal.getSenha() + "</p>");
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("CedulaPU");
            
        FuncionarioNormalJpaController fn = new FuncionarioNormalJpaController(emf);
        FuncionarioNormal modelo_fn = new FuncionarioNormal();
        
         PrintWriter out = response.getWriter();
 
        
         /*<p class="assento">Assento nr: ${assento} </p><br>
        <p class="centro">Nome ${nome}, filho de ${nomePai} e de ${nomeMae}, do sexo<br> ${sexo}, nascido na data ${dataNascimento}, no ditrito de ${distrito}, foi <br> foi registado na data ${dataEmissao} pelo arquivo de indentificacao civil de ${registoCivil} <br></p>
        <p class="func">O funcionario:</p>
        <p class="nomFunc">${nomFunc}</p>*/
         String numeroAssento = request.getParameter("numeroAssento");
        String nome = request.getParameter("nome");
         String sexo = request.getParameter("sexo");
        String distrito = request.getParameter("distrito");
        String nomePai = request.getParameter("nomePai");
        String nomeMae = request.getParameter("nomeMae");
        String dataNascimento = request.getParameter("dataNascimento");                                      
        String dataEmissao = request.getParameter("dataEmissao");
        String registoCivil = request.getParameter("registoCivil");
        
        String idFuncionario = request.getParameter("idFuncionario");
        String nomFun = "";
     
       // out.print(nome);
             
                
                
                    for (FuncionarioNormal funcionarioNormal : fn.findFuncionarioNormalEntities()) {
            if (funcionarioNormal.getIdFuncionario() == Integer.parseInt(idFuncionario)) {
                nomFun = funcionarioNormal.getNome();
            }
                 request.setAttribute("assento",numeroAssento);
                RequestDispatcher view = request.getRequestDispatcher("saida.jsp");
                
                 request.setAttribute("nome",nome );
                view = request.getRequestDispatcher("saida.jsp");
                
                    request.setAttribute("nomePai",nomePai );
                view = request.getRequestDispatcher("saida.jsp");
                
                 request.setAttribute("sexo",sexo);
                view = request.getRequestDispatcher("saida.jsp");
                
                request.setAttribute("nomeMae",nomeMae );
                view = request.getRequestDispatcher("saida.jsp");
                
                 request.setAttribute("dataNascimento",dataNascimento );
                view = request.getRequestDispatcher("saida.jsp");
                
                 request.setAttribute("dataEmissao",dataEmissao);
                view = request.getRequestDispatcher("saida.jsp");
                
                 request.setAttribute("registoCivil",registoCivil);
                view = request.getRequestDispatcher("saida.jsp");
                
               request.setAttribute("nomFun",nomFun);
                view = request.getRequestDispatcher("saida.jsp");
                
                view.forward(request, response);
            }
       
        }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold> 
        }
                
                

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /*
  
    
     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }*/

    /*
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   


