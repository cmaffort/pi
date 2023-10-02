<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.pi.model.dto.Marca" %>
<%@page import="br.cefetmg.pi.model.dto.Modelo" %>
<%@page import="br.cefetmg.pi.model.dto.Categoria" %>
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
            <h3>Inserir Veiculos</h3>
            <form name="frmInserirVeiculo" method='post'>
                <input type='hidden' name='table' value='Veiculo'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Placa:
                        </td>
                        <td>
                            <input type='text' name='placa' maxlength="8" size="8" value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descrição:
                        </td>
                        <td>
                            <input type='text' name='descricao' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Modelo:
                        </td>
                        <td>
                            <select name='codmodelo'>
                                <%
                                    List<Modelo> listModelo = (List<Modelo>) request.getAttribute("listModelo");
                                    for (Modelo modelo: listModelo) {
                                %>
                                        <option                                     
                                            value='<%=modelo.getId()%>'><%=modelo.getDescricao()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Marca:
                        </td>
                        <td>
                            <select name='codmarca'>
                                <%
                                    List<Marca> listMarca = (List<Marca>) request.getAttribute("listMarca");
                                    for (Marca marca: listMarca) {
                                %>
                                        <option                                     
                                            value='<%=marca.getId()%>'><%=marca.getDescricao()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Categoria:
                        </td>
                        <td>
                            <select name='codcategoria'>
                                <%
                                    List<Categoria> listCategoria = (List<Categoria>) request.getAttribute("listCategoria");
                                    for (Categoria categoria: listCategoria) {
                                %>
                                        <option                                     
                                            value='<%=categoria.getId()%>'><%=categoria.getDescricao()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirVeiculo)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/locadora/servletweb?acao=ListarVeiculo'>Listar Veiculos</a><br>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
