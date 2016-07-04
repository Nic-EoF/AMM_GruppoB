<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
  <head>
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <a href='descrizione.jsp'>Home del sito</a>
        <a href="Login">Login</a>
        <h2>Prodotti disponibili</h2>
        <form action="Cliente" method="get">
        <table> <!--costruiamo una tabella per i prodotti-->
            <tr>
                <th>Numero</th>
                <th>Nome</th>
                <th>Foto</th>
                <th>Quantità</th>
                <th>Prezzo</th>
                <th>Carrello</th>
            </tr>
            <c:forEach var="libro" items="${lista}" varStatus="loop">
                <tr>
                    <td>
                         <c:out value="${libro.n}"/>
                    </td>
                    <td>
                        
                    <c:out value="${libro.nome}"/>
                    </td>
                    <td>
                        <img title="immagine"  src="<c:out value="${libro.immagine}"/>" width="110" height="130">
                    </td>
                    <td>
                        <c:out value="${libro.quantità}"/>
                    </td>
                    <td>
                        <c:out value="${libro.prezzo}"/>
                    </td>
                    <td>
                        <button type="submit" name="b_cliente_${loop.count}">Carrello</button>
                    </td> 
                </tr>
            </c:forEach>
        </table>
        </form>
    </body>
</html>
