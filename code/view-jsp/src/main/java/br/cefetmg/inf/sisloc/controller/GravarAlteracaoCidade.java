package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterCidade;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.service.ManterCidade;
import br.cefetmg.pi.model.service.ManterEstado;
import jakarta.servlet.http.HttpServletRequest;

public class GravarAlteracaoCidade {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long codCidade = Long.parseLong(request.getParameter("codCidade"));
            String nome = request.getParameter("nome");

            String sigla = request.getParameter("sigla");
            IManterEstado manterEstado = new ManterEstado();
            Estado estado = manterEstado.pesquisarPorSigla(sigla);

            Cidade cidade = new Cidade();
            cidade.setId(codCidade);
            cidade.setNome(nome);
            cidade.setEstado(estado);

            IManterCidade manterCidade = new ManterCidade();
            boolean updated = manterCidade.alterar(cidade);

            if (updated == true) {
                jsp = ListarCidade.execute(request);
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
