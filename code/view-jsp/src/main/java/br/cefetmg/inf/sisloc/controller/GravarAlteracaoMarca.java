package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.service.IManterMarca;
import br.cefetmg.pi.model.service.ManterMarca;

public class GravarAlteracaoMarca {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long codMarca = Long.parseLong(request.getParameter("codmarca"));
            String descricao = request.getParameter("descricao");

            Marca marca = new Marca();
            marca.setId(codMarca);
            marca.setDescricao(descricao);

            IManterMarca manterMarca = new ManterMarca();
            boolean updated = manterMarca.alterar(marca);

            if (updated == true) {
                jsp = ListarMarca.execute(request);
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
