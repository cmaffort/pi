package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Usuario;
import br.cefetmg.pi.model.service.IManterUsuario;
import br.cefetmg.pi.model.service.ManterUsuario;

public class ExcluirUsuario {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodUsuario que se deseja alterar
            Long usuarioId = Long.parseLong(request.getParameter("cod"));
            IManterUsuario manterUsuario = new ManterUsuario();
            Usuario usuario = manterUsuario.pesquisarPorId(usuarioId);
            boolean delete = manterUsuario.excluir(usuario);
            if (delete != false) {
                jsp = ListarUsuario.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Usuario!";
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
