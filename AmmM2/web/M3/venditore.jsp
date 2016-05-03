<%-- 
    Document   : venditore
    Created on : 23-apr-2016, 16.05.39
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
         <link rel="stylesheet" type="text/css" href="Stile.css">
    </head>
    <body>
        <div class="header">
        <a href='descrizione.jsp'>Home del sito</a>
        <a href='login.jsp'>Login</a>
        </div>
        <div class="cont">
        <h3>Inserisci descrizione del libro:</h3>
        <form action="descrizione.html" method="get">
            <div>
                <label for="nome">Nome:</label>
                <input type="text" name="nome" id="nome" /> <!--Crea un form per inserire un testo-->
            </div>
            <div>
                <label for="immagine">Immagine:</label>
                <input type="url" name="immagine" id="immagine" /> <!--Crea un form per inserire un url-->
            </div>
            <div>
                <label for="descrizione">Descrizione:</label> <!--Crea un form per l'inserimento di un testo molto grande-->
                <textarea rows="4" cols="20" name="descrizione" id="descrizione"> 
                </textarea>
            </div>
            <div>
                <label for="prezzo">Prezzo:</label>
                <input type="text" name="prezzo" id="prezzo" />
            </div>
            <div>
                <label for="quantita">Quantità:</label>  
                <input type="number" name="quantita" id='quantita' min="1">  <!--Crea un form per l'inserimento di un numero-->
            </div>
                 <button type="submit" name="submit_venditore">Invia</button> <!--Crea un pulsante per il submit-->
        </form>
        </div>
    </body>
</html>
