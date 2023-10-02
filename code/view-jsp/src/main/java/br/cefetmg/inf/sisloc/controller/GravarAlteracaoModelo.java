package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.service.IManterModelo;
import br.cefetmg.pi.model.service.ManterModelo;

public class GravarAlteracaoModelo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long codModelo = Long.parseLong(request.getParameter("codmodelo"));
            String descricao = request.getParameter("descricao");

            Modelo modelo = new Modelo();
            modelo.setId(codModelo);
            modelo.setDescricao(descricao);

            IManterModelo manterModelo = new ManterModelo();
            boolean updated = manterModelo.alterar(modelo);

            if (updated == true) {
                jsp = ListarModelo.execute(request);
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
