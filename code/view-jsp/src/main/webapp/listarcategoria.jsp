<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Categoria" %>
<%@page import="java.util.List" %>
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
            <h3>Lista de Categorias</h3>
            <a href='/locadora/inserircategoria.jsp'>Nova Categoria</a>
            <form name="frmCategoria" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Categoria'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Descrição
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<Categoria> listCategoria = (List<Categoria>) request.getAttribute("listCategoria");
                        for (Categoria categoria: listCategoria) {
                    %>
                            <tr>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCategoria&CodCategoria=<%=categoria.getId()%>"><%=categoria.getId()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCategoria&CodCategoria=<%=categoria.getId()%>"><%=categoria.getDescricao()%></a>
                                </td>
                                <td>
                                    <input type='button' value='Excluir' onclick='Excluir(<%=categoria.getId()%>,document.frmCategoria)'>
                                </td>
                            </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>
