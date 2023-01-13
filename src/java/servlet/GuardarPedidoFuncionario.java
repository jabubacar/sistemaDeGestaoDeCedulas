/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.RequerimentoFuncionarioNormalJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.RequerimentoFuncionarioNormal;

/**
 *
 * @author Jozino M. Abubacar
 */
public class GuardarPedidoFuncionario extends HttpServlet {

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
            out.println("<title>Servlet GuardarPedidoFuncionario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuardarPedidoFuncionario at " + request.getContextPath() + "</h1>");
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
       PrintWriter out = response.getWriter();
        RequerimentoFuncionarioNormalJpaController cc = new RequerimentoFuncionarioNormalJpaController();
        RequerimentoFuncionarioNormal modelo_funcionario = new RequerimentoFuncionarioNormal();
        
         String idRequerimentoFunc = request.getParameter("idRequerimentoFunc");
        String nome = request.getParameter("nome");
        String naturalidade = request.getParameter("naturalidade");
        String distrito = request.getParameter("distrito");
        String nomePai = request.getParameter("nomePai");
        String nomeMae = request.getParameter("nomeMae");
        String dataNascimento = request.getParameter("dataNascimento");                                      
        String dataRequerimento = request.getParameter("dataRequerimento");
        String sexo = request.getParameter("sexo");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String nrBI = request.getParameter("nrBI");
        
        String msg = "Cadastro Bem sucedido";
        String err = "O SEU CADASTRO NAO FOI BEM SUCEDIDO <br> os campos: idRequerimentoFunc e nome devem ser todos preenchidos";
        
       
        modelo_funcionario.setDistrito(distrito);
        modelo_funcionario.setEmail(email);
        modelo_funcionario.setIdRequerimentoFunc(Integer.parseInt(idRequerimentoFunc));
        modelo_funcionario.setNaturalidade(naturalidade);
        modelo_funcionario.setNome(nome);
        modelo_funcionario.setNomeMae(nomeMae);
        modelo_funcionario.setNomePai(nomePai);
        modelo_funcionario.setNrBI(nrBI);
        modelo_funcionario.setTelefone(telefone);
        
        /* modelo_funcionario.setDataNascimento(dataNascimento);
        modelo_funcionario.setDataRequerimento(dataRequerimento);*/
         if(idRequerimentoFunc != "" && nome !="" ){
			  //cc.create(modelo_funcionario );
         out.println("<p>" + msg+ "</p>");
         }else{
           out.println("<h2>"+err+"</h2>");
         }
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
