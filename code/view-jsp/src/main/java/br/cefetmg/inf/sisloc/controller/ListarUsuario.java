package br.cefetmg.inf.sisloc.controller;

import java.util.ArrayList;
import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Usuario;
import br.cefetmg.pi.model.service.IManterUsuario;
import br.cefetmg.pi.model.service.ManterUsuario;
import java.util.List;

public class ListarUsuario {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterUsuario manterUsuario = new ManterUsuario();
            List<Usuario> listUsuario = manterUsuario.pesquisarTodos();
            if (listUsuario != null) {
                request.setAttribute("listUsuario", listUsuario);
                jsp = "/listarusuario.jsp";
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
