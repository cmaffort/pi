package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.service.IManterMarca;
import br.cefetmg.pi.model.service.ManterMarca;

public class GravarInsercaoMarca {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String descricao = request.getParameter("descricao");

            Marca marca = new Marca();
            marca.setDescricao(descricao);

            IManterMarca manterMarca = new ManterMarca();
            Long marcaId = manterMarca.cadastrar(marca);

            if (marcaId != null) {
                jsp = ListarMarca.execute(request);
            } else {
                String erro = "Nao foi poss�vel gravar esse registro!";
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
