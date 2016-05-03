<%-- 
    Document   : login
    Created on : 23-apr-2016, 16.05.11
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Biblioteca Storica</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="Stile.css">
    </head>
    <body>
        <div class="header">
        <a href='descrizione.jsp'>Home del sito</a>
        <a href='venditore.jsp'>Venditore</a>
        <a href='cliente.jsp'>Cliente</a>
        </div>
        <div class="cont">
        <h3>Effettua il login</h3>
        <form action="../Login" method="post">
            <div>
                <label for="nome">Nome:</label>
                <input type="text" name=Username" id="nome" />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" name="Password" id="password"/> <!--crea un form per l'inserimento di una password-->
            </div>
            <button type="submit" name="Submit">Login</button>
        </form>
        </div>
    </body>
</html>