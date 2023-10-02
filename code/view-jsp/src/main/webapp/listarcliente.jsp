<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.pi.model.dto.Cliente" %>
<%@page import="br.cefetmg.pi.model.dto.Cidade" %>
<%@page import="java.util.List" %>
<%@page import="br.cefetmg.inf.util.FormatadorData" %>
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
            <h3>Lista de Clientes</h3>
            <a href='/locadora/servletweb?acao=InserirCliente'>Novo Cliente</a>
            <form name="frmCliente" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Cliente'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            Cidade
                        </td>
                        <td>
                            Bairro
                        </td>
                        <td>
                            CPF
                        </td>
                        <td>
                            Data de Nascimento
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Endereço
                        </td>
                        <td>
                            Telefone
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<Cliente> listCliente = (List<Cliente>) request.getAttribute("listCliente");
                        for (Cliente cliente: listCliente) {
                    %>
                            <tr>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=cliente.getId()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=cliente.getNome()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=cliente.getCidade().getNome()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=cliente.getBairro()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=cliente.getCpf()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=FormatadorData.formatar(cliente.getDataNasc(),"dd/MM/yyyy")%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=cliente.getEmail()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=cliente.getEndereco()%></a>
                                </td>
                                <td>
                                    <a href="/locadora/servletweb?acao=AlterarCliente&CodCliente=<%=cliente.getId()%>"><%=cliente.getFone()%></a>
                                </td>
                                <td>                            
                                    <input type='button' value='Excluir' onclick='Excluir(<%=cliente.getId()%>,document.frmCliente)'>
                                </td>
                            </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>
