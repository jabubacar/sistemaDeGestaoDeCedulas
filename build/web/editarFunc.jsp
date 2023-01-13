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
     <a href="listFunc.jsp"><img src="img/back.jpg" width="60px" alt=""></a>
    </div> 
    
    <div class="txt">
     <h1>EDITAR FUNCIONARIO</h1> 
    </div>

</header>


      <div class="principal">
        <div class="titulo">
         <h3>PREENHA O FORMULARIO</h3>
        </div>
        

        <div class="container">

            <form action="" method="get">
                <label for="">
                    IdFuncionario: 
                    <input name="IdFuncionario"type="number" value="1" size="30">
                   </label><br><br>

            <label for="">
                Nome: 
                <input name="nome"type="text" value="Marta Miguel" size="30">
               </label><br><br>
               
               Naturalidade: 
               <input name="nome"type="text" value="Pemba" size="30">
              </label><br><br>
               <label for="">
                Provincia: 
                <input name="provincia" type="text" value="Cabo Deelgado" size="30">
               </label><br><br>

               <label for="">
                Distrito: <br>
                <input name="distrito" type="text" value="pemba">
               </label><br><br>
         
                <label for="">
                 Nome do Pai: <br>
                <input name="nomePai" type="text" value="Miguel Julio" size="30">
                </label><br><br>

                <label for="">
                Nome da Mae: <br>
                <input name="nomeMae" type="text" value="Ancha Bernardo" size="30">
                 </label><br><br>

                 <label for="">
                    Email: <br>
                    <input name="email" type="email" value="mmiguel@gmail.com" size="30">
                     </label><br><br>

                <label for="">
                 Data de nascimento: <br>
                <input name="dataNascimento" type="date" value="09/06/1980">
               </label><br><br>

               Telefone: 
               <input name="Telefone"type="Telefone" value="829805112" size="30">
              </label><br><br>

               <label for=""><br>
                Senha: <br>
                <input name="senha" type="password" value="4321">
               </label><br><br>

               <label for="">
                nome do usuario <br>
                <input type="text" value="mmiguel" >
               </label><br><br>

                <label for="">
                Sexo: <br>
                
                <input type="text" name="sexo" value="femenino">
               
            
               <label for="">
                nr B.I:<br>
                <input type="number" name="nrBI" value="03087345768">
               </label><br><br>
            <div class="sub">
           <button type="submit" name="submit" id="submit"  value="conluir" style="width: auto; ">CONCLUIR</button>
            </div>

            </form>
    </div>
    </div>
</body>
</html>