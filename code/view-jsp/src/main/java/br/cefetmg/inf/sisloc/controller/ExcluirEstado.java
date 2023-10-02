package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.service.ManterEstado;
import jakarta.servlet.http.HttpServletRequest;

public class ExcluirEstado {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do estado para exclusao
            String estadoSigla = request.getParameter("cod");

            IManterEstado manterEstado = new ManterEstado();
            Estado estado = manterEstado.pesquisarPorSigla(estadoSigla);
            boolean delete = manterEstado.excluir(estado);
            if (delete != false) {
                jsp = ListarEstado.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Estado!";
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
