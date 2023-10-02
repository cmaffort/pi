<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>locadora xxx</title>
    </head>
    <center>
            <h3>Inserir Estados</h3>
            <form name="frmInserirEstado" method='post'>
                <input type='hidden' name='table' value='Estado'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                   <tr>
                        <td>
                            Sigla:
                        </td>
                        <td>
                            <input type='text' name='sigla' maxlength="2" size="2" value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type='text' name='nome' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirEstado)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/locadora/servletweb?acao=ListarEstados'>Listar Estados</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
</html>
