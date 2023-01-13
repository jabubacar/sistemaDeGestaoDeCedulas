<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Requerimento para privilegios de funcionario</title>
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
     <a href="index.jsp"><img src="img/back.jpg" width="60px" alt=""></a>
    </div> 
    
    <div class="txt">
     <h1>REQUERER PARA TER PRIVILEGIOS DE FUNCIONARIO</h1> 
    </div>

</header>


      <div class="principal">
        <div class="titulo">
         <h3>PREENHA O FORMULARIO</h3>
        </div>
        

        <div class="container">

            <form action="GuardarPedidoFuncionario" method="get">
                <label for="">
                idRequerimentoFunc: 
                <input name="idRequerimentoFunc"type="number" placeholder ="idRequerimentoFunc" size="30">
               </label><br><br>
            <label for="">
                Nome Completo: 
                <input name="nome"type="text" placeholder ="Nome Completo" size="30">
               </label><br><br>
               
               <label for="">
                Naturalidade: 
                <input name="naturalidade" type="text" placeholde="Naturalidade" size="30">
               </label><br><br>

               <label for="">
                Distrito: <br>
                <input name="distrito" type="text" placeholder="Distrito">
               </label><br><br>
         
                <label for="">
                 Nome do Pai: <br>
                <input name="nomePai" type="text" placeholder="Nome do Pai " size="30">
                </label><br><br>

                <label for="">
                Nome da Mae: <br>
                <input name="nomeMae" type="text" placeholder="Nome da Mae" size="30">
                 </label><br><br>

                <label for="">
                 Data de nascimento: <br>
                <input name="dataNascimento" type="date" placeholder="Data de Nascimento">
               </label><br><br>

               <label for=""><br>
                Data de Requerimento: <br>
                <input name="dataRequerimento" type="date" placeholder="Data de Requerimento">
               </label><br><br>

               <label for="">
                Telefone <br>
                <input type="number" placeholder="telefone" >
               </label><br><br>

               <label for="">
                Email <br>
                <input type="email" placeholder="username@domainname.com.mz" >
               </label><br><br>


               <label for="sexo">
               <select name="sexo">
                   <option value="Masculino">Masculino</option>
                   <option value="Feminino">Feminino</option>
               </select>
               </label>
               
               <label for="">

                scanner do B.I:
                <input  type="file" name="scannerCertidao">
               </label><br><br>
   
            <div class="sub">
           <button type="submit" name="submit" id="submit"  value="ENVIAR" style="width: auto; ">ENVIAR</button>
            </div>

            </form>
    </div>
    </div>