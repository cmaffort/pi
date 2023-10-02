<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.pi.model.dto.Estado" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%  Estado estado = (Estado) request.getAttribute("estado"); %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>
        <center>
            <h3>Alterar Estados</h3>
            <form name="frmAltEstados" method='post'>
                <input type='hidden' name='siglacod' value='<%=estado.getSigla()%>'>
                <input type='hidden' name='table' value='Estado'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=estado.getSigla()%>'>
                <table>
                    <tr>
                        <td>
                            Sigla:
                        </td>
                        <td>
                            <input type='text' name='sigla' size="2" maxlength="2" value='<%=estado.getSigla()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type='text' name='nome' value='<%=estado.getNome()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick='GravarAlterarTabela(document.frmAltEstados);' value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltEstados.cod.value,document.frmAltEstados)'>    
                            <a href='/locadora/inserirestado.jsp'>Inserir Estado</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
