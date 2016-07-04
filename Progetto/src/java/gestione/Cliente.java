/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestione;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import libreria.Libro;
import libreria.LibroFactory;
import libreria.Utente;

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
        
        ArrayList<Libro> listaLibro = LibroFactory.getInstance().getListaLibro();
        String button1 = request.getParameter("b_cliente_1");
        String button2 = request.getParameter("b_cliente_2");
        String button3 = request.getParameter("b_cliente_3");
        String button4 = request.getParameter("b_cliente_4");
        String button5 = request.getParameter("b_cliente_5");
        Integer numero = null;
        
        double soldi;
        
        if(null!=button1){
            numero=1;
            
        } else
        if(null!=button2){
            numero=2;
        } else
        if(null!=button3){
            numero=3;
        } else
        if(null!=button4){
            numero=4;
        } else
        if(null!=button5){
            numero=5;
        }
        
         
        if(null != button1 || null != button2 || null != button3 || null != button4 || null != button5){  
            //String n = request.getParameter("libro.n");
            
            for (Libro libro : listaLibro){
                if(libro.getN().equals(numero)){
                   soldi = (double) session.getAttribute("soldi");
                   String nome = libro.getNome();
                   double prezzo = libro.getPrezzo();
                   double quantità = libro.getQuantità();
                   String immagine = libro.getImmagine();
                   if(prezzo <= soldi){
                   request.setAttribute("nome_cliente", nome);                
                   request.setAttribute("immagine_cliente", immagine);
                   request.setAttribute("prezzo_cliente", prezzo);
                   request.setAttribute("quantità_cliente", quantità);
                   
                   request.getRequestDispatcher("conferma_cliente.jsp").forward(request, response);
                   }else{
                   request.getRequestDispatcher("errore.jsp").forward(request, response);
                   }
                }
            }
            /*
            String nome = request.getParameter("libro.nome");
            String immagine = request.getParameter("libro.immagine");
            String prezzo = request.getParameter("libro.prezzo");
            String quantità = request.getParameter("libro.quantita");
                
            request.setAttribute("nome_cliente", nome);                
            request.setAttribute("immagine_cliente", immagine);
            request.setAttribute("prezzo_cliente", prezzo);
            request.setAttribute("quantità_cliente", quantità);
            request.getRequestDispatcher("conferma_cliente.jsp").forward(request, response);
            */
            
        }else if (null != session.getAttribute("cLoggato")){
            request.setAttribute("lista", listaLibro);
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("descrizione.jsp").forward(request, response);
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
