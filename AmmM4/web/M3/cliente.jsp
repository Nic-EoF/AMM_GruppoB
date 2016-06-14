<%-- 
    Document   : cliente
    Created on : 23-apr-2016, 16.04.13
    Author     : utente
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
    <head>       
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="M3/Stile.css">
    </head>
    <body>
        <div class="header">
        <!--<a href='M3/descrizione.jsp'>Home del sito</a>-->
        <a href='M3/login.jsp'>Login</a>
        </div>
        <div class="cont">
        <label for="filta">Filtra:</label>
        <input type="filtra" name="Filtra" id="password"/>
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
                        
                    <c:out value="${libro.nome}"/>
                    </td>
                    <td>
                        <img title="immagine"  src="<:out value=${libro.immagine}/>" width="110" height="130">
                    </td>
                    <td>
                        <c:out value="${libro.quantità}"/>
                    </td>
                    <td>
                        <c:out value="${libro.prezzo}"/>
                    </td>
                    <td>
                        <a name="link_carrello">Carrello</a>
                    </td> 
                </tr>
            </c:forEach>
         
        </table>
        </div>
    </body>
</html>
