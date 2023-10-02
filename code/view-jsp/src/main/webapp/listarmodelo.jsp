<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Modelo" %>
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
            <h3>Lista de Modelos</h3>
            <a href='/locadora/inserirmodelo.jsp'>Novo Modelo</a>
            <form name="frmModelo" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Modelo'>
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
                        List<Modelo> listModelo = (List<Modelo>) request.getAttribute("listModelo");
                        for (Modelo modelo: listModelo) {
                    %>
                        <tr>
                            <td>
                                <a href="/locadora/servletweb?acao=AlterarModelo&CodModelo=<%=modelo.getId()%>"><%=modelo.getId()%></a>
                            </td>
                            <td>
                                <a href="/locadora/servletweb?acao=AlterarModelo&CodModelo=<%=modelo.getId()%>"><%=modelo.getDescricao()%></a>
                            </td>
                            <td>
                                <input type='button' value='Excluir' onclick='Excluir(<%=modelo.getId()%>,document.frmModelo)'>
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>
