<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Modelo" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%  Modelo modelo = (Modelo) request.getAttribute("modelo"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>

        <center>
            <h3>Alterar Modelos</h3>
            <form name="frmAltModelo" method='post'>                
                <input type='hidden' name='table' value='Modelo'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=modelo.getId()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codmodelo' value='<%=modelo.getId()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descrição:
                        </td>
                        <td>
                            <input type='text' name='descricao' value='<%=modelo.getDescricao()%>'>
                        </td>
                    </tr>
                    <tr>
                       <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltModelo);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltModelo.cod.value,document.frmAltModelo)'>    
                            <a href='/locadora/inserirmodelo.jsp'>Inserir Modelo</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    
    </body>
</html>
