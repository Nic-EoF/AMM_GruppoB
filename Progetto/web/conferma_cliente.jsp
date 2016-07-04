<%-- 
    Document   : conferma_cliente
    Created on : 12-giu-2016, 17.57.43
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <head>
        <title>Cliente Conferma</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <form action="Cliente" method="post">
            <div>
                <div>
                    Nome:
                </div>
                <div>
                    ${nome_cliente}
                </div>
            </div>
            <div>
                <div>
                    Immagine:
                </div>
                <div>
                    ${immagine_cliente}
                </div>
            </div>
            <div>
                <div>
                    Quantità:
                </div>
                <div>
                    ${quantità_cliente}
                </div>
            </div>
            <div>
                <div>
                    Prezzo:
                </div>
                <div>
                    ${prezzo_cliente}
                </div>
            </div>
           
            <div>
                    <button type="submit" name="conferma_c_button">Conferma</button>
            </div>
        </form>
    </body>
</html>
