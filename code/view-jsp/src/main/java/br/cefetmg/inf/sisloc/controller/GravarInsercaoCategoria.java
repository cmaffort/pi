package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.service.IManterCategoria;
import br.cefetmg.pi.model.service.ManterCategoria;

public class GravarInsercaoCategoria {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String descricao = request.getParameter("descricao");

            Categoria categoria = new Categoria();
            categoria.setDescricao(descricao);

            IManterCategoria manterCategoria = new ManterCategoria();
            Long categoriaId = manterCategoria.cadastrar(categoria);

            if (categoriaId != null) {
                jsp = ListarCategoria.execute(request);
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
