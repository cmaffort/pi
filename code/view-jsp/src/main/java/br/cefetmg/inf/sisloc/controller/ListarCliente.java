package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.service.IManterCliente;
import br.cefetmg.pi.model.service.ManterCliente;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class ListarCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterCliente manterCliente = new ManterCliente();
            List<Cliente> listCliente = manterCliente.pesquisarTodos();
            if (listCliente != null) {
                request.setAttribute("listCliente", listCliente);
                jsp = "/listarcliente.jsp";
            } else {
                String erro = "Não existe Clientes!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

}
