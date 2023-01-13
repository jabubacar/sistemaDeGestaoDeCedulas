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
    <td>Jozino</td>
    <td>Nampula</td>
    <td>Nampula</td>
    <td>Momade Abubacar</td>
    <td>Judith Tomas</td>
    <td>06/07/2001</td>
    <td>06/12/2022</td>
    <td>852092115</td>
    <td>jabubacar@unilurio.ac.mz</td>
    <td>Femenino</td>
  </tr>
</table>

<input type="file" style="margin-left:10px;" name="" id="">


<div class="sub">

 <a href="gerar2.jsp"><input type="text" value="GERAR" id="submit" size="3" style="width: auto; "></a>
  
 <button type="submit" id="submit" style="width: auto; ">REJEITAR</button>

 
   
</div>

</body>
</html>