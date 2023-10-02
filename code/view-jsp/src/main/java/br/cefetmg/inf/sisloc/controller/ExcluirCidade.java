package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.service.IManterCidade;
import br.cefetmg.pi.model.service.ManterCidade;
import jakarta.servlet.http.HttpServletRequest;

public class ExcluirCidade {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo repectiva cidade a ser excluida
            Long cidadeId = Long.parseLong(request.getParameter("cod"));
            IManterCidade manterCidade = new ManterCidade();
            Cidade cidade = manterCidade.pesquisarPorId(cidadeId);
            boolean delete = manterCidade.excluir(cidade);
            if (delete != false) {
                jsp = ListarCidade.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Cidade!";
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
