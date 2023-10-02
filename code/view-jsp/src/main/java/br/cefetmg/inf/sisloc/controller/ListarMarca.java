package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.service.IManterMarca;
import br.cefetmg.pi.model.service.ManterMarca;
import java.util.List;

public class ListarMarca {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterMarca manterMarca = new ManterMarca();
            List<Marca> listMarca = manterMarca.pesquisarTodos();
            if (listMarca != null) {
                request.setAttribute("listMarca", listMarca);
                jsp = "/listarmarca.jsp";
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
