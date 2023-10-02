package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.service.IManterCategoria;
import br.cefetmg.pi.model.service.ManterCategoria;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarCategoria {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String codCategoria = request.getParameter("CodCategoria");
            IManterCategoria manterCategoria = new ManterCategoria();
            Categoria categoria = manterCategoria.pesquisarPorId(Long.parseLong(codCategoria));
            if(categoria != null){
                request.setAttribute("categoria", categoria);
                jsp = "/alterarcategoria.jsp";
            } else {
               String erro = "Ocorreu erro ao alterar a categoria";
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
