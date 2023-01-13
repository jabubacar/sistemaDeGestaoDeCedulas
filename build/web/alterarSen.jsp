<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de registo</title>
    <link rel="stylesheet" href="Style.css">
    <style>
        h1{
        text-align: center;
        }
        .principal{
            margin-top: 10px;
        }
    </style>
</head>
<body>

         
    <br><br><div class="principal">
    
        <header class="cab">
    
            <div class="voltar" style="float:left;">
             <a href="funcionario.jsp"><img src="img/back.jpg" width="60px" alt=""></a>
            </div> 
            
            <div class="txt">
             <h1>ALTERAR SENHA</h1> 
            </div>
        
        </header>
    
        <div class="container">
            <form action="" method="post">
            <label for="">
                USERNAME: <br>
                <input type="text" value="USERNAME" size="35">
               </label><br><br>
            
            <label for="">
             ACTUAL PASSWORD: <br>
             <input type="password" value="useremail@domain.com" size="35">
            </label><br><br>
         
            <label for="">
             NOVA PASSWORD : <br>
             <input type="password" value="password" size="35">
            </label>
         
            
         
            <label for=""><br><br>
             CONFIRMAR NOVA PASSWORD: <br>
             <input type="password" value="password" size="35">
            </label><br><br>
            <div class="sub">
                <button type="submit" name="submit" id="submit"  value="ENVIAR" style="width: auto; ">ENVIAR</button>
                 </div>
        </div>
    </form>
    </div>
    
</body>
</html>