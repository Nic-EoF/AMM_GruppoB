/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function (){
     $("#filtra").keyup(function()  ///esegue questo ogni volta che l'untente rilascia un tasto
     {
          var text = $("#filtra").val(); //prende il valore 
           
          $.ajax(
            {
            url: "filter.json",  ///mappa l'ajax sulla json filter
            data:{
              q : text //chiave: q, testo: text
            },
            dataType: 'json',
            success : function(data, state){   
            },
            error : function(data, state){
            }
        });
    
    
     }
}

