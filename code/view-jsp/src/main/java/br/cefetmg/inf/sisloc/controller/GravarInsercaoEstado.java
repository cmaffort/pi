package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.service.ManterEstado;
import jakarta.servlet.http.HttpServletRequest;

public class GravarInsercaoEstado {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String sigla = request.getParameter("sigla");
            String nome = request.getParameter("nome");

            Estado estado = new Estado();
            estado.setSigla(sigla);
            estado.setNome(nome);

            IManterEstado manterEstado = new ManterEstado();
            Long estadoId = manterEstado.cadastrar(estado);

            if (estadoId != null) {
                jsp = ListarEstado.execute(request);
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
