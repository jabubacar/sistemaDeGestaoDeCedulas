<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Login</title>
    <link rel="stylesheet" href="Style.css">
    <style>
        .principal{
            margin-top:50px;
        }
    </style>

</head>
<body>
<br><br><br>
    <div class="principal">
        <div class="titulo">
         <header>FORMULARIO DE LOGIN</header>
        </div>
        

        <div class="container">
           
            <form action="Validacao" method="post">
            <label for="">
             USERNAME: <br>
             <input type="text" name="username" placeholder="USERNAME" size="35">
            </label><br><br>
         
            <label for="">
             PASSWORD: <br>
             <input type="password" name="senha"  placeholder="PASSWORD" size="35">
            </label><br><br>
             
            <ul style="list-style:circle;"> 
                <li><a href="requerer.jsp">Requer Cedula</a></li>
                <li><a href="RequererFunc.jsp">Requerimento-Funcionario</a></li>
                
             </ul>
  
            <div class="sub">
            <button type="submit" name="submit" id="submit"  value="ENVIAR" style="width: auto; ">ENVIAR</button>
            </div>
            <div style="color:red;">${mensagem}</div>
          </form>
    </div>
    </div>
    
</body>
</html>