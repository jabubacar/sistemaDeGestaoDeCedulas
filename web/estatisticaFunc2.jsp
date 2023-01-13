<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>estatisticas do funcionario</title>
    <link rel="stylesheet" href="Style.css">
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
div.principal{
    
    margin: 0 auto;
    margin-top: 100px;
    border: 6px solid rgb(117, 109, 109);;
    box-sizing: border-box;
    border-radius: 10px;
    background-color:white;
    width: 80%;
    padding:none;
}

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
         <h1>ESTATISTICAS DO FUNCIONARIO</h1> 
        </div>
    </header>

    <div class="principal">
        <table>
          <tr>
            <th>IdFuncionario</th>
            <th>nome do Funcionario</th>
            <th>Data</th>
            <th>total pedidos</th>
            <th>Cedulas geradas</th>
            <th>pedidos rejeitados</th>
            <th>cedulas eliminadas</th>
            <th>cedulas editadas</th>
            <th>cedulas impressas</th>
            <th>cedulas partilhadas por email</th>
    
          </tr>
          <tr>
            <td>1</td>
            <td>Mario Adriano</td>
            <td>08/05/2022</td>
            <td>20</td>
            <td>15</td>
            <td>5</td>
            <td>2</td>
            <td>1</td>
            <td>20</td>
            <td>7</td>
          </tr>
        </table>

</body>
</html>