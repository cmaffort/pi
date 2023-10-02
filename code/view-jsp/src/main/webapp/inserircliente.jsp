<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.pi.model.dto.Cliente" %>
<%@page import="br.cefetmg.pi.model.dto.Cidade" %>
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
            <h3>Inserir Clientes</h3>
            <form name="frmInserirCliente" method='post'>
                <input type='hidden' name='table' value='Cliente'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Nome Cliente:
                        </td>
                        <td>
                            <input type='text' name='nome' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Cliente:
                        </td>
                        <td>
                            <select name='codcidade'>
                                <%
                                    List<Cidade> listCidade = (List<Cidade>) request.getAttribute("listCidade"); 
                                    for (Cidade cidade: listCidade) {
                                %>
                                        <option                                     
                                            value='<%=cidade.getId()%>'><%=cidade.getNome()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td>
                            Bairro:
                        </td>
                        <td>
                            <input type='text' name='bairro' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            CPF:
                        </td>
                        <td>
                            <input type='text' name='cpf' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Data de Nascimento:
                        </td>
                        <td>
                            <input type='text' name='datanasc' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input type='text' name='email' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endereço:
                        </td>
                        <td>
                            <input type='text' name='endereco' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Telefone:
                        </td>
                        <td>
                            <input type='text' name='fone' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirCliente)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/locadora/servletweb?acao=ListarCliente'>Listar Clientes</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
