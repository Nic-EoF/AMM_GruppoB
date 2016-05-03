<%-- 
    Document   : conferma_cliente
    Created on : 3-mag-2016, 17.37.52
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>   
        <title>Conferma Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="Stile.css">
    </head>
    <body>
        <h1>Dati prodotto:</h1>
        <p>Dome: ${nome_cliente}</p>
        <p>Immagine: ${immagine_cliente}</p>
        <p>Prezzo: ${prezzo_cliente}</p>
        <p>Quantità: ${quantità_cliente}</p>
        <button type="submit" name="submit_conferma">Conferma</button>
    </body>
</html>
