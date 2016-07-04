<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Libri, Storia, Biblioteca">
        <meta name="description" content="Usai Nicola">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <a href='descrizione.jsp'>Home del sito</a>
        <a href='Venditore'>Venditore</a>
        <a href='Cliente'>Cliente</a>
        <h3>Effettua il login</h3>
        <form action="Login" method="get">
            <div>
                <label for="nome">Nome:</label>
                <input type="text" name ="nome" id="nome" value="${nome}"/>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" value="${password}"/> <!--crea un form per l'inserimento di una password-->
            </div>
            <button type="submit" name="l_button">Login</button>
        </form>
    </body>
</html>