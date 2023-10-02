<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Usuario" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%  Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>

        <center>
            <h3>Alterar Usuarios</h3>
            <form name="frmAltUsuario" method='post'>                
                <input type='hidden' name='table' value='Usuario'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=usuario.getId()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codusuario' value='<%=usuario.getId()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type='text' name='nome' value='<%=usuario.getNome()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome Completo:
                        </td>
                        <td>
                            <input type='text' name='nomecompleto' value='<%=usuario.getNomeCompleto()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input type='text' name='email' value='<%=usuario.getEmail()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Senha:
                        </td>
                        <td>
                            <input type='password' name='senha' value='<%=usuario.getSenha()%>'>
                        </td>
                    </tr>
                    <tr>
                       <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltUsuario);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltUsuario.cod.value,document.frmAltUsuario)'>    
                            <a href='/locadora/inserirusuario.jsp'>Inserir Usuario</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    
    </body>
</html>
