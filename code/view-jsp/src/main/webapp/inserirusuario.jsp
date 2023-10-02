<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>

        <center>
            <h3>Inserir Usuarios</h3>
             <form name="frmInserirUsuario" method='post'>
                <input type='hidden' name='table' value='Usuario'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type='text' name='nome' value=''>
                        </td>
                    </tr>                   
                    <tr>
                        <td>
                            Nome Completo:
                        </td>
                        <td>
                            <input type='text' name='nomecompleto' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input type='text' name='email' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Senha:
                        </td>
                        <td>
                            <input type='password' name='senha' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirUsuario)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/locadora/servletweb?acao=ListarUsuario'>Listar Usuarios</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    
    </body>
</html>
