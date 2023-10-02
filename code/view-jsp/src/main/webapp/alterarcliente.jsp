<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.pi.model.dto.Cliente" %>
<%@page import="br.cefetmg.pi.model.dto.Cidade" %>
<%@page import="java.util.List" %>
<%@page import="br.cefetmg.inf.util.FormatadorData" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%  Cliente cliente = (Cliente) request.getAttribute("cliente"); %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>
         <center>
            <h3>Alterar Cliente</h3>
            <form name='frmAltCliente' method='post'>                
                <input type='hidden' name='table' value='Cliente'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=cliente.getId()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codcliente' value='<%=cliente.getId()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome Cliente:
                        </td>
                        <td>
                            <input type='text' name='nome' value='<%=cliente.getNome()%>'>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            Cidade:
                        </td>
                        <td>
                            <select name='codcidade'>                                
                                <%
                                    String selected = "";
                                    List<Cidade> listCidade = (List<Cidade>) request.getAttribute("listCidade");
                                
                                    for (Cidade cidade: listCidade) {
                                        if(cidade.getId() == cliente.getCidade().getId()) 
                                            selected = "selected"; 
                                        else
                                            selected = ""; 
                                %>
                                        <option value='<%=cidade.getId()%>' <%=selected%>><%=cidade.getNome()%></option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                     <tr>
                        <td>
                            Bairro:
                        </td>
                        <td>
                            <input type='text' name='bairro' value='<%=cliente.getBairro()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            CPF:
                        </td>
                        <td>
                            <input type='text' name='cpf' value='<%=cliente.getCpf()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Data de Nascimento:
                        </td>
                        <td>
                            <input type='text' name='dataNasc' value='<%=FormatadorData.formatar(cliente.getDataNasc(),"dd/MM/yyyy")%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input type='text' name='email' value='<%=cliente.getEmail()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endereço:
                        </td>
                        <td>
                            <input type='text' name='endereco' value='<%=cliente.getEndereco()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Telefone:
                        </td>
                        <td>
                            <input type='text' name='fone' value='<%=cliente.getFone()%>'>
                        </td>
                    </tr>                    
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' value='Gravar' onclick = "GravarAlterarTabela(document.frmAltCliente);" />&nbsp;
                            <input type='reset' value='Redefinir' />
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltCliente.cod.value,document.frmAltCliente);' />    
                            <a href='/locadora/servletweb?acao=InserirCliente'>Inserir Cliente</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
