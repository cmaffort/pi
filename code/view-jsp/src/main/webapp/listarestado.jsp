<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.pi.model.dto.Estado" %>
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
            <h3>Lista de Estados</h3>
            <a href='/locadora/inserirestado.jsp'>Novo Estado</a>
            <form name="frmEstado" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Estado'>
                <table>
                    <tr>
                        <td>
                            Sigla
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<Estado> listEstado = (List<Estado>) request.getAttribute("listEstado");
                        for (Estado estado: listEstado) {
                    %>
                            <tr>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarEstado&Sigla=<%=estado.getSigla()%>"><%=estado.getSigla()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarEstado&Sigla=<%=estado.getSigla()%>"><%=estado.getNome()%></a>
                                </td>
                                <td>
                                    <input type='button' value='Excluir' onclick='Excluir("<%=estado.getSigla()%>",document.frmEstado)'>
                                </td>
                            </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>
