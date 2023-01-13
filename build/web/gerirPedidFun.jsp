<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>gerir pedidos</title>
    <link rel="stylesheet" href="tab.css">
    <style>
    
 table, td, th {
  border: 1px solid black;
}
.tab{
  max-width: 100%;
}

table{
  border-collapse: collapse;
  max-width:100%;
  margin:10px;

}
th,td{
  width: 100px;
  height: 70px;
  text-align: center;
}


    </style>
</head>
<body>
   

  <header class="cab">
    
    <div class="voltar" style="float:left;">
     <a href="admin.jsp"><img src="img/back.jpg" width="60px" alt=""></a>
    </div> 
    
    <div class="txt">
     <h1 style="text-align: center;">GERIR PEDIDOS</h1>

    </div>
</header>

<div class="principal">
<table>
  <tr>
    <th>Id</th>
    <th>Nome</th>
    <th>Naturalidade</th>
    <th>Distrito</th>
    <th>Nome do Pai</th>
    <th>Nome da Mae</th>
    <th>Data de Nascimento</th>
    <th>Data de Requerimento</th>
    <th>Telefone</th>
    <th>Email</th>
    <th>Sexo</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Gil Antonio</td>
    <td>Cabo Delgado</td>
    <td>Pemba</td>
    <td>Antonio Joao</td>
    <td>Milga Pedro</td>
    <td>16/07/1990</td>
    <td>07/12/2022</td>
    <td>847092119</td>
    <td>gilantonio@gmail.com</td>
    <td>Masculino</td>
  </tr>
</table>
<label for="">
    Abrir scannerBI
<input type="file" style="margin-left:10px;" name="" id="">
</label>

<div class="sub">

 <a href="cadastrarFunc.jsp"><input type="text" value="CADASTRAR" id="submit" size="8" style="width: auto; "></a>
  
 <button type="submit" id="submit" style="width: auto; ">REJEITAR</button>

 
   
</div>

</body>
</html>