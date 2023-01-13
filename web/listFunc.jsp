<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LISTA DE CEDULAS</title>
    <link rel="stylesheet" href="Style.css">

    <style>
      section{
        background-color: brown;
        margin-left: 20%;
        margin-right: 20%;
        margin-top: 0;
      }
      
   div{
        display: inline;
        margin-left:0;
        margin-right: 50px;
      }
li.ga{
    background-color: rgb(117, 109, 109);;
}

      ul {
  list-style-type: none;
  padding: 20px;
  overflow: hidden;
  background-color: #ce3c3c;

}

li {
  float: left;
  height: 40px;
  padding-top: 30px;
}

li a {
 /* display: block;*/ 
  color: white;
  margin: 10px;
  text-align: center;
  padding: 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111111;
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
         <h1>LISTA DE FUNCIONARIOS</h1>
        </div>
    
    </header>
    <input type="search" value="procurar">

    <section>
        <ul>
           
            <li class="ga">
                
                <div  id="assento">01</div>

                <div id="nomeA"> Mario Adriano</div>
                
                <div id="editar"><a href="editarFunc.jsp">editar</a></div>

                <div id="eliminar"><a href=""> eliminar </a></div>

                <div><a href="estatisticaFunc2.jsp">Ver estatistica</a></div>
            </li>

            <li>
                
                <div  id="assento">02</div>

                <div id="nomeA"> Mario Adriano</div>
                
                <div id="editar"><a href="editarFunc.jsp">editar</a></div>

                <div id="eliminar"><a href=""> eliminar </a></div>

                <div><a href="estatisticaFunc2.jsp">Ver estatistica</a></div>
            </li>

            <li class="ga">
                
                <div  id="assento">03</div>

                <div id="nomeA"> Mario Adriano</div>
                
                <div id="editar"><a href="editarFun.jsp">editar</a></div>

                <div id="eliminar"><a href=""> eliminar </a></div>

                <div><a href="estatisticaFunc2.jsp">Ver estatistica</a></div>
            </li>

            <li>
                
                <div  id="assento">04</div>

                <div id="nomeA"> Mario Adriano</div>
                
                <div id="editar"><a href="editarFunc.jsp">editar</a></div>

                <div id="eliminar"><a href=""> eliminar </a></div>

                <div><a href="estatisticaFunc2.jsp">Ver estatistica</a></div>
            </li>

            <li class="ga">
                
                <div  id="assento">05</div>

                <div id="nomeA"> Mario Adriano</div>
                
                <div id="editar"><a href="editarFun.jsp">editar</a></div>

                <div id="eliminar"><a href=""> eliminar </a></div>

                <div><a href="estatisticaFunc2.jsp">Ver estatistica</a></div>
            </li>

        </ul>
    </section>
    
</body>
</html>