/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestione;

import biblioteca.Libro;
import biblioteca.LibroFactory;
import biblioteca.Utente;
import biblioteca.UtenteFactory;
import biblioteca.Venditore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"}, loadOnStartup = 0 )

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
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";

    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 

    public void init(){

        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;

        try {

            Class.forName(JDBC_DRIVER);

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        }

        UtenteFactory.getInstance().setConnectionString(dbConnection);

    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);

        if (request.getParameter("Submit") != null) {  ///se è stato premuto il pulsante submit...
            String username = request.getParameter("Username"); ///si caricano i dati inseriti
            String password = request.getParameter("Password");

            ArrayList<Utente> listaUtenti = UtenteFactory.getInstance().getUserList();  //si "prendono" gli utenti
            
            for (Utente u : listaUtenti) {  ///per ogni utente, si controlla se nome utente e password coincidono con quelli inseriti.
                if (u.getNome().equals(username) && u.getPassword().equals(password)) {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("id", u.getId());
                    if (u instanceof Venditore) {
                        session.setAttribute("vLoggato", true);  ///se è un venditore, si va alla servlet Venditore
                        request.setAttribute("venditore", u);
                        request.getRequestDispatcher("Venditore").forward(request, response);
                    } 
                    else {
                        session.setAttribute("cLoggato", true);
                        request.setAttribute("cliente", u);
                        request.getRequestDispatcher("Cliente").forward(request, response);  ///se è un cliente, si va alla servlet Cliente
                    }
                }
            }
        }
     
        request.getRequestDispatcher("M3/errore.jsp").forward(request, response);  ///altrimenti, si va a una pagina di errore

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
