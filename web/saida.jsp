<%-- 
    Document   : saida
    Created on : 21 Dec 2022, 22:50:20
    Author     : Jozino M. Abubacar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cedula recem gerada</title>
        
        <style>
            body{
                background-image: linear-gradient(to right, #434343 0%, black 100%);
             }

         .cab{
              background-color: rgb(29, 25, 25);
              padding: 0;
              margin: 0;
              overflow: hidden;
              font-size: 0.5em;
              color: whitesmoke
              }

        div.voltar{
          float:left;
        padding: 10px;
            }
            
            .assento{
            margin-left: 80%;
            }
            h2,.func, .nomFunc,h1{
                text-align: center;;
            }
            .cedula{
                
                width: 40%;
                margin-left: 30%;
                margin-top: 40px;
                background-color: brown;
                border: 1px solid black;
                border-radius: 5px;
            }
            .centro{
            text-align: justify;
            margin-left: 20px;
            margin-right: 20px;
            }
        </style>
    </head>
    <body>
       
        <header class="cab">
    
            <div class="voltar" style="float:left;">
             <a href="cadastrarCedula.jsp"><img src="img/back.jpg" width="60px" alt=""></a>
            </div> 
            
            <div class="txt">
             <h1>CEDULA RECEM GERADA</h1> 
            </div>
        
        </header>
       
        <div class="cedula">
        <h2>Cedula Pessoal</h2>
        
        <p class="assento">Assento nr: ${assento} </p><br>
        <p class="centro">Nome ${nome}, filho de ${nomePai} e de ${nomeMae}, do sexo<br> ${sexo}, nascido na data ${dataNascimento}, no ditrito de ${distrito}, foi <br> foi registado na data ${dataEmissao} pelo arquivo de indentificacao civil de ${registoCivil} <br></p>
        <p class="func">O funcionario:</p>
        <p class="nomFunc">${nomFun}</p>

        </div>
    </body>
</html>
