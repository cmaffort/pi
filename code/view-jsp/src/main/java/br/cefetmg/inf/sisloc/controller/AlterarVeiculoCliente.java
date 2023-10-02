package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.VeiculoCliente;
import br.cefetmg.pi.model.service.IManterVeiculoCliente;
import br.cefetmg.pi.model.service.ManterVeiculoCliente;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarVeiculoCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodVeiculo que se deseja alterar
            Long codVeiculoCliente = Long.parseLong(request.getParameter("CodVeiculoCliente"));
            IManterVeiculoCliente manterVeiculoCliente = new ManterVeiculoCliente();
            VeiculoCliente veiculoCliente = manterVeiculoCliente.pesquisarPorId(codVeiculoCliente);
            if (veiculoCliente != null) {
                request.setAttribute("veiculoCliente", veiculoCliente);
                jsp = "/alterarveiculocliente.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar VeiculoCliente!";
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
