package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterCidade;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.service.ManterCidade;
import br.cefetmg.pi.model.service.ManterEstado;
import jakarta.servlet.http.HttpServletRequest;

public class GravarInsercaoCidade {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String nome = request.getParameter("nome");

            String sigla = request.getParameter("sigla");
            IManterEstado manterEstado = new ManterEstado();
            Estado estado = manterEstado.pesquisarPorSigla(sigla);

            Cidade cidade = new Cidade();
            cidade.setNome(nome);
            cidade.setEstado(estado);

            IManterCidade manterCidade = new ManterCidade();
            Long cidadeId = manterCidade.cadastrar(cidade);

            if (cidadeId != null) {
                jsp = ListarCidade.execute(request);
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
