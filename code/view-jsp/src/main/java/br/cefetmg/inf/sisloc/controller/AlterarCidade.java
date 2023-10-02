package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterCidade;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.service.ManterCidade;
import br.cefetmg.pi.model.service.ManterEstado;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarCidade {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodCidade que se deseja alterar
            Long codCidade = Long.parseLong(request.getParameter("CodCidade"));

            IManterCidade manterCidade = new ManterCidade();
            Cidade cidade = manterCidade.pesquisarPorId(codCidade);
            if (cidade != null) {
                request.setAttribute("cidade", cidade);

                IManterEstado manterEstado = new ManterEstado();
                List<Estado> listEstado = manterEstado.pesquisarTodos();
                request.setAttribute("listEstado", listEstado);

                jsp = "/alterarcidade.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Cidade!";
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
