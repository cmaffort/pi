package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.service.ManterEstado;
import jakarta.servlet.http.HttpServletRequest;

public class GravarAlteracaoEstado {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long siglaCod = Long.parseLong(request.getParameter("siglacod"));
            String sigla = request.getParameter("sigla");
            String nome = request.getParameter("nome");

            Estado estado = new Estado();
            estado.setId(siglaCod);
            estado.setSigla(sigla);
            estado.setNome(nome);

            IManterEstado manterEstado = new ManterEstado();
            boolean updated = manterEstado.alterar(estado);

            if (updated != true) {
                jsp = ListarEstado.execute(request);
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
