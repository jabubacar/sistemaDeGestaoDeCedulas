/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.RequerenteJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Requerente;

/**
 *
 * @author Jozino M. Abubacar
 */
public class GuardarPedidoUsuario extends HttpServlet {

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
            out.println("<title>Servlet GuardarPedidoUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuardarPedidoUsuario at " + request.getContextPath() + "</h1>");
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
       
       RequerenteJpaController cc = new RequerenteJpaController();
       
       Requerente modelo_guardar = new Requerente();
       
            String nome = request.getParameter("nome");
            String naturalidade = request.getParameter("naturalidade");
            String distrito = request.getParameter("distrito");
            String nomePai = request.getParameter("nomePai");
            String nomeMae = request.getParameter("nomeMae");
            String dataNascimento = request.getParameter("dataNascimento");
            String dataRequerimento = request.getParameter("dataRequerimento");
            String telefone = request.getParameter("telefone");
            String sexo = request.getParameter("sexo");
            String email = request.getParameter("email");
            String idRequerente = request.getParameter("idRequerente");
            String msg = "Cadastro Bem sucedido";
            String err = "O SEU CADASTRO NAO FOI BEM SUCEDIDO <br> os campos: id do Requerente e nome devem ser todos preenchidos";
         
             modelo_guardar.setDistrito(distrito);
             modelo_guardar.setEmail(email);
             modelo_guardar.setIdRequerente(Integer.parseInt(idRequerente));
             modelo_guardar.setNaturalidade(naturalidade);
             modelo_guardar.setNome(nome);
             modelo_guardar.setNomeMae(nomeMae);
             modelo_guardar.setNomePai(nomePai);
             modelo_guardar.setTelefone(telefone);
             /*modelo_guardar.setDataNascimento(date(dataNascimento));
             modelo_guardar.setDataRequerimento(date(dataRequerimento));
             */  
             
             
                
         if(idRequerente !="" && nome !="" ){
			 // cc.create(modelo_guardar );
         out.println("<p>" + msg+ "</p>");
         }else{
           out.println("<p>"+err+"</p>");
         }
               /*
                <input name="nome"type="text" placeholder="NomeCompleto" size="30">
               
                <input name="naturalidade" type="text" placeholder="Naturalidade" size="30">
              
                Distrito: <br>
                <input name="distrito" type="text" placeholder="Distrito">
             
                <input name="nomePai" type="text" placeholder="Nome do Pai " size="30">
              
                <input name="nomeMae" type="text" placeholder="Nome da Mae" size="30">
               
                <input name="dataNascimento" type="date" placeholder="Data de Nascimento">
              
                <input name="dataRequerimento" type="date" placeholder="Data de Requerimento">
               
                <input type="number" placeholder="telefone" >
           
                Sexo: <
       
       
       */
       
       
       
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
