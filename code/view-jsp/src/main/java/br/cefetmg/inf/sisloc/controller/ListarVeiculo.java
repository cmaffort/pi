package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.service.IManterVeiculo;
import br.cefetmg.pi.model.service.ManterVeiculo;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class ListarVeiculo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterVeiculo manterVeiculo = new ManterVeiculo();
            List<Veiculo> listVeiculo = manterVeiculo.pesquisarTodos();
            if (listVeiculo != null) {
                request.setAttribute("listVeiculo", listVeiculo);
                jsp = "/listarveiculo.jsp";
            } else {
                String erro = "Nao existe Veiculo!";
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
