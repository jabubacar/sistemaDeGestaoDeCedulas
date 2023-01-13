<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EDITAR CEDULA</title>
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
     <a href="Listar2.jsp"><img src="img/back.jpg" width="60px" alt=""></a>
    </div> 
    
    <div class="txt">
     <h1>EDITAR CEDULA</h1> 
    </div>

</header>


      <div class="principal">
        <div class="titulo">
         <h3>ALTERAR DADOS</h3>
        </div>
        

        <div class="container">

            <form action="" method="get">
                Numero de assento: 
                <input name="numeroAssento"type="number" value="1" size="30">
               </label><br><br>
               
               <label for="">

            <label for="">
                Nome: 
                <input name="nome"type="text" value="Jozino Momade zeii" size="30">
               </label><br><br>
               
               <label for="">
                Provincia: 
                <input name="provincia" type="text" value="Nampula" size="30">
               </label><br><br>

               <label for="">
                Distrito: <br>
                <input name="distrito" type="text" value="Nampula">
               </label><br><br>
         
                <label for="">
                 Nome do Pai: <br>
                <input name="nomePai" type="text" value="Momade Abubacar" size="30">
                </label><br><br>

                <label for="">
                Nome da Mae: <br>
                <input name="nomeMae" type="text" value="Judith Tomas" size="30">
                 </label><br><br>

                <label for="">
                 Data de nascimento: <br>
                <input name="dataNascimento" type="date" value="07/06/2001">
               </label><br><br>

               <label for=""><br>
                Data de Emissao: <br>
                <input name="dataEmissao" type="date" value="08/05/2022">
               </label><br><br>

               <label for="">
                Registo Civil <br>
                <input type="text" value="solteiro" >
               </label><br><br>

                <label for="">
                Sexo: <br>

                <input type="text" name="sexo" value="masculino" ">
                </label><br><br>

               <label for="">
                Id funcionario<br>
                <input type="number" value="1" name="idFuncionario" >
               </label><br><br>
            <div class="sub">
           <button type="submit" name="submit" id="submit"  value="conluir" style="width: auto; ">CONCLUIR</button>
            </div>

            </form>
    </div>
    </div>
</body>
</html>