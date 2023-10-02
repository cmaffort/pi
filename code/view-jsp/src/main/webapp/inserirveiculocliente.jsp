<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Veiculo" %>
<%@page import="br.cefetmg.pi.model.dto.Cliente" %>
<%@page import="java.util.List" %>
<%@ include file="/menu.jsp" %>

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
            <h3>Inserir VeiculosClientes</h3>
            <form name="frmInserirVeiculoCliente" method='post'>
                <input type='hidden' name='table' value='VeiculoCliente'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Cliente:
                        </td>
                        <td>
                            <select name='codcliente'>
                                <%
                                    List<Cliente> listCliente = (List<Cliente>) request.getAttribute("listCliente");
                                    for (Cliente cliente: listCliente) {
                                %>
                                        <option                                     
                                            value='<%=cliente.getId()%>'><%=cliente.getNome()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Veículo
                        </td>
                        <td>
                            <select name='placa'>
                                <%
                                    List<Veiculo> listVeiculo = (List<Veiculo>) request.getAttribute("listVeiculo");
                                    for (Veiculo veiculo: listVeiculo) {
                                %>
                                        <option                                     
                                            value='<%=veiculo.getPlaca()%>'><%=veiculo.getDescricao()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirVeiculoCliente)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/locadora/servletweb?acao=ListarVeiculoCliente'>Listar Veiculos Clientes</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
