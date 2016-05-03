<%-- 
    Document   : Descrizione
    Created on : 18-apr-2016, 18.09.57
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Biblioteca Storica</title> <!--metainformazioni varie sulla pagina-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="M3/Stile.css">
    </head>
    <body>
        <div class="header">
        <a href='M3/login.jsp'>Login</a> <!--link alla pagina login-->
        <p>Sommario:</p> <!--creiamo una lista di link interni per i vari paragrafi-->
        <ul>
            <li><a href="#1">Che cosa vendiamo?</a></li>
            <li><a href="#2">Dove ci troviamo?</a></li>
        </ul>
        </div>
        <div class="cont">
        <h1>BIBLIOTECA STORICA</h1>
        <p>Benvenuti in Biblioteca Storica!</p>
        <h2 id='1'>Che cosa vendiamo</h2>
        <p>Vendiamo libri di storia, riguardanti tutti i periodi storici di tutto il mondo</p>
        <h3>Sono disponibili anche nella mia lingua?</h3>
        <p>I nostri libri sono disponibili in tutte le lingue del mondo, dall'Albanese allo Zulu.</p>
        <h2 id='2'>Dove ci troviamo</h2>
        <p>Abbiamo sedi in tutto il mondo e spediamo in tutte le parti del mondo!</p>
        <h3>Qual'è la mia sede più vicina?</h3>
        <p>Inviate un e-mail all'indirizzo: bibsto@bs.com con il vostro indirizzo e provvederemo a farvi sapere.</p>
        </div>
    </body>
</html>
