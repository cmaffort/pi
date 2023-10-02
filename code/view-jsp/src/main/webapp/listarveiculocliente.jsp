<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.VeiculoCliente" %>
<%@page import="java.util.List" %>
<%@ include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>locadora xxx</title>
    </head>
    <body>
       <center>
            <h3>Lista de VeiculoClientes</h3>
            <a href='/locadora/servletweb?acao=InserirVeiculoCliente'>Novo VeiculoCliente</a>
            <form name="frmVeiculoCliente" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='VeiculoCliente'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Cliente
                        </td>
                        <td>
                            Veiculo
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<VeiculoCliente> listVeiculoCliente = (List<VeiculoCliente>) request.getAttribute("listVeiculoCliente");                    
                        for (VeiculoCliente veiculoCliente: listVeiculoCliente) {
                    %>
                            <tr>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarVeiculoCliente&CodVeiculoCliente=<%=veiculoCliente.getId()%>"><%=veiculoCliente.getId()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarVeiculoCliente&CodVeiculoCliente=<%=veiculoCliente.getId()%>"><%=veiculoCliente.getCliente().getNome()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarVeiculoCliente&CodVeiculoCliente=<%=veiculoCliente.getId()%>"><%=veiculoCliente.getVeiculo().getDescricao()%></a>
                                </td>
                                <td>                            
                                    <input type='button' value='Excluir' onclick='Excluir(<%=veiculoCliente.getId()%>,document.frmVeiculoCliente)'>
                                </td>
                            </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>
