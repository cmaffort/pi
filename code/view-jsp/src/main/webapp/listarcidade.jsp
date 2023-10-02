<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Cidade" %>
<%@page import="java.util.List" %>
<%@ include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>locadora xxx</title>
    </head>
    <body>
       <center>
            <h3>Lista de Cidades</h3>
            <a href='/locadora/servletweb?acao=InserirCidade'>Nova Cidade</a>
            <form name="frmCidade" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Cidade'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            Estado
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<Cidade> listCidade = (List<Cidade>) request.getAttribute("listCidade");
                        for (Cidade cidade: listCidade) {
                    %>
                            <tr>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCidade&CodCidade=<%=cidade.getId()%>"><%=cidade.getId()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCidade&CodCidade=<%=cidade.getId()%>"><%=cidade.getNome()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCidade&CodCidade=<%=cidade.getId()%>"><%=cidade.getEstado().getNome()%></a>
                                </td>
                                <td>                            
                                    <input type='button' value='Excluir' onclick='Excluir(<%=cidade.getId()%>,document.frmCidade)'>
                                </td>
                            </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>
