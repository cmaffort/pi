<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Locadora xxx</title>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
    </head>
    <body>

    <h1>Login</h1>
    
    <form name="frmLogin" method='post'>
        <label>Usuário:
            <input type="text" name="nome" id="nome" maxlength="10" size="12">    
        </label><br />
                <br />
        <label>Senha:&nbsp;&nbsp;&nbsp;
            <input type="password" name="senha" id="senha" maxlength="10" size="12">    
        </label><br />
                <br />
        
        <button type="button" onclick="validarCamposLogin()">Acessar</button>        
    </form>  
   
    </body>
</html>
