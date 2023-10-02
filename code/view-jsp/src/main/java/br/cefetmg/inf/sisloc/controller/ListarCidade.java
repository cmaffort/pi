package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.service.IManterCidade;
import br.cefetmg.pi.model.service.ManterCidade;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class ListarCidade {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterCidade manterCidade = new ManterCidade();
            List<Cidade> listCidade = manterCidade.pesquisarTodos();
            if (listCidade != null) {
                request.setAttribute("listCidade", listCidade);
                jsp = "/listarcidade.jsp";
            } else {
                String erro = "Nao existe Cidades!";
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
