package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Usuario;
import br.cefetmg.pi.model.service.IManterUsuario;
import br.cefetmg.pi.model.service.ManterUsuario;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarUsuario {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Usuario que deseja alterar
            Long codUsuario = Long.parseLong(request.getParameter("CodUsuario"));
            IManterUsuario manterUsuario = new ManterUsuario();
            Usuario usuario = manterUsuario.pesquisarPorId(codUsuario);
            if (usuario != null) {
                request.setAttribute("usuario", usuario);
                jsp = "/alterarusuario.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Usuario!";
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
