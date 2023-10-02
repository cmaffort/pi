package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.VeiculoCliente;
import br.cefetmg.pi.model.service.IManterVeiculoCliente;
import br.cefetmg.pi.model.service.ManterVeiculoCliente;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class ListarVeiculoCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterVeiculoCliente manterVeiculoCliente = new ManterVeiculoCliente();

            List<VeiculoCliente> listVeiculoCliente = manterVeiculoCliente.pesquisarTodos();
            if (listVeiculoCliente != null) {
                request.setAttribute("listVeiculoCliente", listVeiculoCliente);
                jsp = "/listarveiculocliente.jsp";
            } else {
                String erro = "Nao existe VeiculoCliente!";
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
