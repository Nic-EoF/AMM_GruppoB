<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <a href='descrizione.jsp'>Home del sito</a>
        <a href="Login">Login</a>
       <!-- <a href='login.jsp'>Login</a>-->
        
        <h3>Inserisci descrizione del libro:</h3>
        <form action="Venditore" method="get">
            <div>
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome"/> <!--Crea un form per inserire un testo-->
            </div>
            <div>
                <label for="immagine">Immagine:</label>
                <input type="url" id="immagine" name="immagine"/> <!--Crea un form per inserire un url-->
            </div>
            <div>
                <label for="descrizione">Descrizione:</label> <!--Crea un form per l'inserimento di un testo molto grande-->
                <textarea rows="4" cols="20" name="descrizione" id="descrizione"> 
                </textarea>
            </div>
            <div>
                <label for="prezzo">Prezzo:</label>
                <input type="text" id="prezzo" name="prezzo"/>
            </div>
            <div>
                <label for="quantita">Quantità:</label>  
                <input type="number" name="quantita" id='quantita' min="1">  <!--Crea un form per l'inserimento di un numero-->
            </div>
                 <button type="submit" name="b_venditore">Invia</button> <!--Crea un pulsante per il submit-->
        </form>
    </body>
</html>
