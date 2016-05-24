<%-- 
    Document   : conferma_venditore
    Created on : 3-mag-2016, 16.02.35
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <title>Conferma Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="Stile.css">
    </head>
    </head>
    <body>
        <h2>INSERIMENTO AVVENUTO!!!</h2>
        <h1>Dati prodotto:</h1>
        <p>Nome: ${nome}</p>
        <p>Immagine: ${immagine}</p>
        <p>Prezzo: ${prezzo}</p>
        <p>Quantità: ${quantità}</p>
        <a href='login.jsp'>Torna indietro</a>
    </body>
</html>
