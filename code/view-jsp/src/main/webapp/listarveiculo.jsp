<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Veiculo" %>
<%@page import="java.util.List" %>
<%@include file="/menu.jsp" %>

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
            <h3>Lista de Veiculos</h3>
            <a href='/locadora/servletweb?acao=InserirVeiculo'>Novo Veiculo</a>
            <form name="frmVeiculo" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Veiculo'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Descrição
                        </td>
                        <td>
                            Modelo
                        </td>
                        <td>
                            Marca
                        </td>
                        <td>
                            Categoria
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<Veiculo> listVeiculo = (List<Veiculo>) request.getAttribute("listVeiculo");
                        for (Veiculo veiculo: listVeiculo) {
                    %>
                            <tr>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarVeiculo&Placa=<%=veiculo.getPlaca()%>"><%=veiculo.getPlaca()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarVeiculo&Placa=<%=veiculo.getPlaca()%>"><%=veiculo.getDescricao()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarVeiculo&Placa=<%=veiculo.getPlaca()%>"><%=veiculo.getModelo().getDescricao()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarVeiculo&Placa=<%=veiculo.getPlaca()%>"><%=veiculo.getMarca().getDescricao()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarVeiculo&Placa=<%=veiculo.getPlaca()%>"><%=veiculo.getCategoria().getDescricao()%></a>
                                </td>
                                <td>                            
                                    <input type='button' value='Excluir' onclick='Excluir("<%=veiculo.getPlaca()%>",document.frmVeiculo)'>
                                </td>
                            </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>
