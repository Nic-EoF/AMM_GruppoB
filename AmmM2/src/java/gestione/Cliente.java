/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestione;

import biblioteca.Libro;
import biblioteca.LibroFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author utente
 */
@WebServlet(name = "Cliente", urlPatterns = {"/Cliente"})
public class Cliente extends HttpServlet {

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
        
            
            HttpSession session = request.getSession(false);
            
            if(session.getAttribute("cLoggato").equals(true)){
            ArrayList<Libro> listaLibro = LibroFactory.getInstance().getLibroList();
            request.setAttribute("lista", listaLibro);
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }else{
            request.getRequestDispatcher("errore.jsp");
            }
            
            if(request.getParameter("link_carrello")!=null){
                String nome = request.getParameter("libro.nome");
                String immagine = request.getParameter("libro.immagine");
                String prezzo = request.getParameter("libro.prezzo");
                String quantità = request.getParameter("libro.quantita");
                
                request.setAttribute("nome_cliente", nome);
                request.setAttribute("immagine_cliente", immagine);
                request.setAttribute("prezzo_cliente", prezzo);
                request.setAttribute("quantità_cliente", quantità);
                request.getRequestDispatcher("conferma_cliente.jsp").forward(request, response);
                if(request.getParameter("submit_conferma")!=null){
                    request.getRequestDispatcher("conferma_cliente.jsp").forward(request, response);
                }
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
