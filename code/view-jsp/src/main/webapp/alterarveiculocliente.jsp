<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.VeiculoCliente" %>
<%@page import="br.cefetmg.pi.model.dto.Veiculo" %>
<%@page import="br.cefetmg.pi.model.dto.Cliente" %>
<%@page import="java.util.List" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%  VeiculoCliente veiculoCliente = (VeiculoCliente) request.getAttribute("veiculoCliente"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>
         <center>
            <h3>Alterar Propriedade do Veículo</h3>
            <form name="frmAltVeiculoCliente" method='post'>                
                <input type='hidden' name='table' value='VeiculoCliente'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=veiculoCliente.getId()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codveiculocliente' value='<%=veiculoCliente.getId()%>' readonly>
                        </td>
                    </tr>                    
                    <tr>
                        <td>
                            Cliente:
                        </td>
                        <td>
                            <select name='codcliente'>                                
                                <%
                                    String selected="";
                                    List<Cliente> listCliente = (List<Cliente>) request.getAttribute("listCliente");
                                    for (Cliente cliente: listCliente) {
                                        if(cliente.getId()== veiculoCliente.getCliente().getId()) 
                                            selected = "selected"; 
                                        else
                                            selected = "";                                     
                                %>
                                    <option value='<%=cliente.getId()%>' <%=selected%>><%=cliente.getNome()%></option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td>
                            Veiculo:
                        </td>
                        <td>
                            <select name='placa'>              
                                <%                               
                                    List<Veiculo> listVeiculo = (List<Veiculo>) request.getAttribute("listVeiculo");
                                    for (Veiculo veiculo: listVeiculo) {
                                        if(veiculo.getPlaca().equals(veiculoCliente.getVeiculo().getPlaca())) 
                                            selected = "selected"; 
                                        else
                                            selected = ""; 
                                %>
                                        <option value='<%=veiculo.getPlaca()%>' <%=selected%>><%=veiculo.getDescricao()%></option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltVeiculoCliente);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltVeiculoCliente.cod.value,document.frmAltVeiculoCliente)'>    
                            <a href='/locadora/servletweb?acao=InserirVeiculoCliente'>Inserir VeiculoCliente</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
