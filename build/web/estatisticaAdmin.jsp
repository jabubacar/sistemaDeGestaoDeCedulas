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
         <a href="admin.jsp"><img src="img/back.jpg" width="60px" alt=""></a>
        </div> 
        
        <div class="txt">
         <h1>ESTATISTICAS GERAIS</h1> 
        </div>
    </header>

    <div class="principal">
        <table>
          <tr>
            <th>Data</th>
            <th>Total pedidos</th>
            <th>Total de Cedulas geradas</th>
            <th>Total pedidos rejeitados</th>
            <th>Total de cedulas eliminadas</th>
            <th>Total de cedulas editadas</th>
            <th>Total de cedulas impressas</th>
            <th>Cedulas partilhadas por email</th>
            <th>funcionario com mais cedulas geradas</th>
            <th>quantidade de funcionarios</th>
    
          </tr>
          <tr>
            <td>08/05/2022</td>
            <td>70</td>
            <td>20</td>
            <td>9</td>
            <td>6</td>
            <td>5</td>
            <td>50</td>
            <td>30</td>
            <td>Mario Adriano</td>
            <td>14</td>
          </tr>
        </table>

</body>
</html>