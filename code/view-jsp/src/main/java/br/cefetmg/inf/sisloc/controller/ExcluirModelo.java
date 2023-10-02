package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.service.IManterModelo;
import br.cefetmg.pi.model.service.ManterModelo;

public class ExcluirModelo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodModelo que se deseja alterar
            Long modeloId = Long.parseLong(request.getParameter("cod"));
            IManterModelo manterModelo = new ManterModelo();
            Modelo modelo = manterModelo.pesquisarPorId(modeloId);
            boolean delete = manterModelo.excluir(modelo);
            if (delete != false) {
                jsp = ListarModelo.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Modelo!";
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
