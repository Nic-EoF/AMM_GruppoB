<%-- 
    Document   : cliente
    Created on : 23-apr-2016, 16.04.13
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <title>Cliente</title>
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
        <h2>Prodotti disponibili</h2>
        <table> <!--costruiamo una tabella per i prodotti-->
            <tr>
                <th>Nome</th>
                <th>Foto</th>
                <th>Quantità</th>
                <th>Prezzo</th>
                <th>Carrello</th>
            </tr>
            <c:forEach var="libro" items="${lista}">
                <tr>
                    <td>
                        <c:out value="libro.nome"/>
                    </td>
                    <td>
                        <img title="preistoria"  src="<:out value=${libro.immagine}/>" width="110" height="130">
                    </td>
                    <td>
                        <c:out value="libro.quantità"/>
                    </td>
                    <td>
                        <c:out value="libro.prezzo"/>
                    </td>
                    <td>
                        <a href='cliente.html' name="link_carrello">Carrello</a>
                    </td> 
                </tr>
            </c:forEach>
         
        </table>
        </div>
    </body>
</html>
