package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Usuario;
import br.cefetmg.pi.model.service.IManterUsuario;
import br.cefetmg.pi.model.service.ManterUsuario;

public class GravarAlteracaoUsuario {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long codUsuario = Long.parseLong(request.getParameter("codusuario"));
            String nome = request.getParameter("nome");
            String nomeCompleto = request.getParameter("nomecompleto");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            Usuario usuario = new Usuario();
            usuario.setId(codUsuario);
            usuario.setNome(nome);
            usuario.setNomeCompleto(nomeCompleto);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            IManterUsuario manterUsuario = new ManterUsuario();
            boolean updated = manterUsuario.alterar(usuario);

            if (updated == true) {
                jsp = ListarUsuario.execute(request);
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
