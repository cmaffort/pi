<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Usuario" %>
<%@page import="java.util.List" %>
<%@include file="/menu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Locadora xxx</title>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
    </head>
    <body>
        <center>
            <h3>Lista de Usuarios</h3>
            <a href='/locadora/inserirusuario.jsp'>Novo Usuario</a>
            <form name="frmUsuario" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Usuario'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            Nome Completo
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Senha
                        </td>
                        
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<Usuario> listUsuario = (List<Usuario>) request.getAttribute("listUsuario");
                        for (Usuario usuario: listUsuario) {
                    %>
                        <tr>
                            <td>
                                <a href="/locadora/servletweb?acao=AlterarUsuario&CodUsuario=<%=usuario.getId()%>"><%=usuario.getId()%></a>
                            </td>
                            <td>
                                <a href="/locadora/servletweb?acao=AlterarUsuario&CodUsuario=<%=usuario.getId()%>"><%=usuario.getNome()%></a>
                            </td>
                            <td>
                                <a href="/locadora/servletweb?acao=AlterarUsuario&CodUsuario=<%=usuario.getId()%>"><%=usuario.getNomeCompleto()%></a>
                            </td>
                            <td>
                                <a href="/locadora/servletweb?acao=AlterarUsuario&CodUsuario=<%=usuario.getId()%>"><%=usuario.getEmail()%></a>
                            </td>
                            <td>
                                <a href="/locadora/servletweb?acao=AlterarUsuario&CodUsuario=<%=usuario.getId()%>"><%=usuario.getSenha()%></a>
                            </td>
                            <td>
                                <input type='button' value='Excluir' onclick='Excluir(<%=usuario.getId()%>,document.frmUsuario)'>
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>
