<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Marca"%>
<%@ include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%  Marca marca = (Marca) request.getAttribute("marca"); %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>

        <center>
            <h3>Alterar Marcas</h3>
            <form name="frmAltMarca" method='post'>                
                <input type='hidden' name='table' value='Marca'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=marca.getId()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codmarca' value='<%=marca.getId()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descrição:
                        </td>
                        <td>
                            <input type='text' name='descricao' value='<%=marca.getDescricao()%>'>
                        </td>
                    </tr>
                    <tr>
                       <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltMarca);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltMarca.cod.value,document.frmAltMarca)'>    
                            <a href='/locadora/inserirmarca.jsp'>Inserir Marca</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
