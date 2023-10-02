package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.service.IManterVeiculo;
import br.cefetmg.pi.model.service.ManterVeiculo;
import jakarta.servlet.http.HttpServletRequest;

public class ExcluirVeiculo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do veiculo para exclusao
            String veiculoPlaca = request.getParameter("cod");
            IManterVeiculo manterVeiculo = new ManterVeiculo();
            Veiculo veiculo = manterVeiculo.pesquisarPorPlaca(veiculoPlaca);
            boolean delete = manterVeiculo.excluir(veiculo);
            if (delete != false) {
                jsp = ListarVeiculo.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Veiculo!";
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
