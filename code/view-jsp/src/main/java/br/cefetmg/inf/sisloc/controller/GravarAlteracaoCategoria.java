package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.service.IManterCategoria;
import br.cefetmg.pi.model.service.ManterCategoria;

public class GravarAlteracaoCategoria {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long codCategoria = Long.parseLong(request.getParameter("codcategoria"));
            String descricao = request.getParameter("descricao");

            Categoria categoria = new Categoria();
            categoria.setId(codCategoria);
            categoria.setDescricao(descricao);

            IManterCategoria manterCategoria = new ManterCategoria();
            boolean updated = manterCategoria.alterar(categoria);

            if (updated == true) {
                jsp = ListarCategoria.execute(request);
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
