<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>preencher formulario de emissao de pedido</title>
    <link rel="stylesheet" href="Style.css">
    
    <style>
   
    h1{
    text-align: center;
    }
    </style>
</head>
<body>

<header class="cab">
    
    <div class="voltar" style="float:left;">
     <a href="gerir2.jsp"><img src="img/back.jpg" width="60px" alt=""></a>
    </div> 
    
    <div class="txt">
     <h1>PROCESSO DE CADASTRO DO FUNCIONARIO</h1> 
    </div>

</header>


      <div class="principal">
        <div class="titulo">
         <h3>PREENHA O FORMULARIO</h3>
        </div>
        

        <div class="container">

            <form action="" method="get">


            <label for="">
                Nome: 
                <input name="nome"type="text" value="Nome Completo" size="30">
               </label><br><br>
               
               Naturalidade: 
               <input name="nome"type="text" value="Naturalidade" size="30">
              </label><br><br>
               <label for="">
                Provincia: 
                <input name="provincia" type="text" value="Provincia" size="30">
               </label><br><br>

               <label for="">
                Distrito: <br>
                <input name="distrito" type="text" value="Distrito">
               </label><br><br>
         
                <label for="">
                 Nome do Pai: <br>
                <input name="nomePai" type="text" value="Nome do Pai " size="30">
                </label><br><br>

                <label for="">
                Nome da Mae: <br>
                <input name="nomeMae" type="text" value="Nome da Mae" size="30">
                 </label><br><br>

                 <label for="">
                    Email: <br>
                    <input name="email" type="email" value="username@domainname.com" size="30">
                     </label><br><br>

                <label for="">
                 Data de nascimento: <br>
                <input name="dataNascimento" type="date" value="Data de Nascimento">
               </label><br><br>

               Telefone: 
               <input name="Telefone"type="Telefone" value="telefone" size="30">
              </label><br><br>

               <label for=""><br>
                Senha: <br>
                <input name="senha" type="password" value="senha">
               </label><br><br>

               <label for="">
                nome do usuario <br>
                <input type="text" value="username" >
               </label><br><br>

                <label for="">
                Sexo: <br>
                <label for="">
                Femenino:
                <input type="radio" name="sexo" style="width: 10%;">
                </label><br>

                <label for="">
                Masculino:
                <input type="radio" name="sexo" style="width: 9%;">
               </label><br><br>
               </label>
            
               <label for="">
                nr B.I:<br>
                <input type="number" name="nrBI">
               </label><br><br>
            <div class="sub">
           <button type="submit" name="submit" id="submit"  value="conluir" style="width: auto; ">CONCLUIR</button>
            </div>

            </form>
    </div>
    </div>
</body>
</html>