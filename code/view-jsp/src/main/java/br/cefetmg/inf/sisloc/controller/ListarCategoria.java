package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.service.IManterCategoria;
import br.cefetmg.pi.model.service.ManterCategoria;
import java.util.List;

public class ListarCategoria {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterCategoria manterCategoria = new ManterCategoria();
            List<Categoria> listCategoria = manterCategoria.pesquisarTodos();
            if (listCategoria != null) {
                request.setAttribute("listCategoria", listCategoria);
                jsp = "/listarcategoria.jsp";
            } else {
                String erro = "Nao existe registro!";
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
