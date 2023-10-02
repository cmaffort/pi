package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.dto.VeiculoCliente;
import br.cefetmg.pi.model.service.IManterCliente;
import br.cefetmg.pi.model.service.IManterVeiculo;
import br.cefetmg.pi.model.service.IManterVeiculoCliente;
import br.cefetmg.pi.model.service.ManterCliente;
import br.cefetmg.pi.model.service.ManterVeiculo;
import br.cefetmg.pi.model.service.ManterVeiculoCliente;
import jakarta.servlet.http.HttpServletRequest;

public class GravarAlteracaoVeiculoCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long codVeiculoCliente = Long.parseLong(request.getParameter("codveiculocliente"));

            Long codCliente = Long.parseLong(request.getParameter("codcliente"));

            IManterCliente manterCliente = new ManterCliente();
            Cliente cliente = manterCliente.pesquisarPorId(codCliente);

            String placa = request.getParameter("placa");
            IManterVeiculo manterVeiculo = new ManterVeiculo();
            Veiculo veiculo = manterVeiculo.pesquisarPorPlaca(placa);

            VeiculoCliente veiculoCliente = new VeiculoCliente();

            veiculoCliente.setId(codVeiculoCliente);
            veiculoCliente.setCliente(cliente);
            veiculoCliente.setVeiculo(veiculo);

            IManterVeiculoCliente manterVeiculoCliente = new ManterVeiculoCliente();
            boolean updated = manterVeiculoCliente.alterar(veiculoCliente);

            if (updated == true) {
                jsp = ListarVeiculoCliente.execute(request);
            } else {
                String erro = "Nao foi possivel gravar a alteracao desse registro";
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
