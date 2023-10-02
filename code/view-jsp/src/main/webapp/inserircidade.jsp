<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Estado" %>
<%@page import="java.util.List" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>
        <center>
            <h3>Inserir Cidades</h3>
            <form name="frmInserirCidade" method='post'>
                <input type='hidden' name='table' value='Cidade'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Nome Cidade:
                        </td>
                        <td>
                            <input type='text' name='nome' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Estado:
                        </td>
                        <td>
                            <select name='sigla'>
                                <%
                                    List<Estado> listEstado = (List<Estado>) request.getAttribute("listEstado");
                                    for (Estado estado: listEstado) {
                                %>
                                        <option                                     
                                            value='<%=estado.getSigla()%>'><%=estado.getNome()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirCidade)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/locadora/servletweb?acao=ListarCidade'>Listar Cidades</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
