package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.service.IManterModelo;
import br.cefetmg.pi.model.service.ManterModelo;
import java.util.List;

public class ListarModelo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterModelo manterModelo = new ManterModelo();
            List<Modelo> listModelo = manterModelo.pesquisarTodos();
            if (listModelo != null) {
                request.setAttribute("listModelo", listModelo);
                jsp = "/listarmodelo.jsp";
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
