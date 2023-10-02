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

public class GravarInsercaoVeiculoCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long codCliente = Long.parseLong(request.getParameter("codcliente"));
            String placa = request.getParameter("placa");

            IManterCliente manterCliente = new ManterCliente();
            Cliente cliente = manterCliente.pesquisarPorId(codCliente);

            IManterVeiculo manterVeiculo = new ManterVeiculo();
            Veiculo veiculo = manterVeiculo.pesquisarPorPlaca(placa);

            VeiculoCliente veiculoCliente = new VeiculoCliente();
            veiculoCliente.setCliente(cliente);
            veiculoCliente.setVeiculo(veiculo);

            IManterVeiculoCliente manterVeiculoCliente = new ManterVeiculoCliente();
            Long veiculoClienteId = manterVeiculoCliente.cadastrar(veiculoCliente);

            if (veiculoClienteId != null) {
                jsp = ListarVeiculoCliente.execute(request);
            } else {
                String erro = "Nao foi possivel gravar esse registro!";
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
