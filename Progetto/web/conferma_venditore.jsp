<%-- 
    Document   : conferma_venditore
    Created on : 10-giu-2016, 18.44.00
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Venditore Conferma</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <form action="venditore.jsp" method="post">
            <div>
                <div>
                    Nome:
                </div>
                <div>
                    ${nome}
                </div>
            </div>
            <div>
                <div>
                    Immagine:
                </div>
                <div>
                    ${immagine}
                </div>
            </div>
            <div>
                <div>
                    Descrizione:
                </div>
                <div>
                    ${descrizione}
                </div>
            </div>
            <div>
                <div>
                    Prezzo:
                </div>
                <div>
                    ${prezzo}
                </div>
            </div>
            <div>
                <div>
                    Quantità:
                </div>
                <div>
                    ${quantità}
                </div>
            </div>
            <div>
                    <button type="submit" name="v_button">Conferma</button>
            </div>
        </form>
</body>
</html>
