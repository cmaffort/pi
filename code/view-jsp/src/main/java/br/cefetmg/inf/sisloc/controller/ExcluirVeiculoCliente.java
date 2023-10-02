package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.VeiculoCliente;
import br.cefetmg.pi.model.service.IManterVeiculoCliente;
import br.cefetmg.pi.model.service.ManterVeiculoCliente;
import jakarta.servlet.http.HttpServletRequest;

public class ExcluirVeiculoCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do veiculo para exclusao
            Long veiculoClienteId = Long.parseLong(request.getParameter("cod"));
            IManterVeiculoCliente manterVeiculoCliente = new ManterVeiculoCliente();
            VeiculoCliente veiculoCliente = manterVeiculoCliente.pesquisarPorId(veiculoClienteId);
            boolean delete = manterVeiculoCliente.excluir(veiculoCliente);
            if (delete != false) {
                jsp = ListarVeiculoCliente.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir VeiculoCliente!";
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
