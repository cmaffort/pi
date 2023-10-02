<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Cidade" %>
<%@page import="br.cefetmg.pi.model.dto.Estado" %>
<%@page import="java.util.List" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%  Cidade cidade = (Cidade) request.getAttribute("cidade"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>
        <center>
            <h3>Alterar Cidade</h3>
            <form name="frmAltCidade" method='post'>                
                <input type='hidden' name='table' value='Cidade'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=cidade.getId()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codCidade' value='<%=cidade.getId()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome Cidade:
                        </td>
                        <td>
                            <input type='text' name='nome' value='<%=cidade.getNome()%>'>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Estado:
                        </td>
                        <td>
                            <select name='sigla'>                                
                                <%
                                    String selected = "";
                                    List<Estado> listEstado = (List<Estado>) request.getAttribute("listEstado");

                                    for (Estado estado : listEstado) {
                                        if (estado.getSigla().equals(cidade.getEstado().getSigla())) {
                                            selected = "selected";
                                        } else {
                                            selected = "";
                                        }
                                %>
                                        <option value='<%=estado.getSigla()%>' <%=selected%>><%=estado.getNome()%></option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltCidade);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltCidade.cod.value, document.frmAltCidade)'>    
                            <a href='/locadora/servletweb?acao=InserirCidade'>Inserir Cidade</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
