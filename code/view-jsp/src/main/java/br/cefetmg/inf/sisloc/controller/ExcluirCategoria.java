package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.service.IManterCategoria;
import br.cefetmg.pi.model.service.ManterCategoria;

public class ExcluirCategoria {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodCategoria que se deseja alterar
            Long categoriaId = Long.parseLong(request.getParameter("cod"));
            IManterCategoria manterCategoria = new ManterCategoria();
            Categoria categoria = manterCategoria.pesquisarPorId(categoriaId);
            boolean delete = manterCategoria.excluir(categoria);
            if (delete != false) {
                jsp = ListarCategoria.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Categoria!";
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
