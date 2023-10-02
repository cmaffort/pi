<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Veiculo" %>
<%@page import="br.cefetmg.pi.model.dto.Marca" %>
<%@page import="br.cefetmg.pi.model.dto.Modelo" %>
<%@page import="br.cefetmg.pi.model.dto.Categoria" %>
<%@page import="java.util.List" %>
<%@include file="/menu.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%  Veiculo veiculo = (Veiculo) request.getAttribute("veiculo"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora xxx</title>
    </head>
    <body>
         <center>
            <h3>Alterar Veículo</h3>
            <form name="frmAltVeiculo" method='post'>                
                <input type='hidden' name='table' value='Veiculo'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=veiculo.getPlaca()%>'>
                <input type='hidden' name='codveiculo' value='<%=veiculo.getId()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='placa' value='<%=veiculo.getPlaca()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descricao:
                        </td>
                        <td>
                            <input type='text' name='descricao' value='<%=veiculo.getDescricao()%>'>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            Modelo
                        </td>
                        <td>
                            <select name='codmodelo'>                                
                                <%
                                    String selected="";
                                    List<Modelo> listModelo = (List<Modelo>) request.getAttribute("listModelo");
                                    for (Modelo modelo: listModelo) {
                                        if(modelo.getId() == veiculo.getModelo().getId())
                                            selected = "selected"; 
                                        else
                                            selected = ""; 
                                %>
                                        <option value='<%=modelo.getId()%>' <%=selected%>><%=modelo.getDescricao()%></option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                     <tr>
                        <td>
                            Marca
                        </td>
                        <td>
                            <select name='codmarca'>                                
                                <%
                                    List<Marca> listMarca = (List<Marca>) request.getAttribute("listMarca");
                                    for (Marca marca: listMarca) {
                                        if(marca.getId() == veiculo.getMarca().getId())
                                            selected = "selected"; 
                                        else
                                            selected = ""; 
                                %>
                                    <option value='<%=marca.getId()%>' <%=selected%>><%=marca.getDescricao()%></option>                                
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                     <tr>
                        <td>
                            Categoria
                        </td>
                        <td>
                            <select name='codcategoria'>                                
                                <%
                                    List<Categoria> listCategoria = (List<Categoria>) request.getAttribute("listCategoria");
                                    for (Categoria categoria: listCategoria) {
                                        if(categoria.getId() == veiculo.getCategoria().getId())
                                            selected = "selected"; 
                                        else
                                            selected = "";    
                                %>
                                    <option value='<%=categoria.getId()%>' <%=selected%>><%=categoria.getDescricao()%></option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltVeiculo);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltVeiculo.cod.value,document.frmAltVeiculo)'>    
                            <a href='/locadora/servletweb?acao=InserirVeiculo'>Inserir Veiculo</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
