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
import libreria.Cliente;
import libreria.Saldo;
import libreria.Utente;
import libreria.UtenteFactory;
import libreria.Venditore;

/**
 *
 * @author utente
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        

        ArrayList<Utente> listaUtenti = UtenteFactory.getInstance().getListaUtenti();

        String button = request.getParameter("l_button");

        String nome = request.getParameter("nome");

        String password = request.getParameter("password");
        
        Saldo saldo;
        double soldi;

        if (null != session.getAttribute("vLoggato")) {
            request.getRequestDispatcher("Venditore").forward(request, response);
        } else if (null != session.getAttribute("cLoggato")) {
            request.getRequestDispatcher("Cliente").forward(request, response);
        } else if (null != button) {
            for (Utente user : listaUtenti) {
                if (user.getNome().equals(nome) && user.getPassword().equals(password)) {
                    session.setAttribute("loggedIn", true);
                    if (user instanceof Venditore) {
                        session.setAttribute("vLoggato", true);
                        request.getRequestDispatcher("Venditore").forward(request, response);
                    }
                    if (user instanceof Cliente) {
                        saldo = user.getSaldo();
                        soldi = saldo.getSoldi();
                        session.setAttribute("soldi", soldi);
                        session.setAttribute("cLoggato", true);
                        request.getRequestDispatcher("Cliente").forward(request, response);
                    }
                }

            }
            request.getRequestDispatcher("errore.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
