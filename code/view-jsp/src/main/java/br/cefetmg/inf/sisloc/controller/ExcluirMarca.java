package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.service.IManterMarca;
import br.cefetmg.pi.model.service.ManterMarca;

public class ExcluirMarca {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodMarca que se deseja alterar
            Long marcaId = Long.parseLong(request.getParameter("cod"));
            IManterMarca manterMarca = new ManterMarca();
            Marca marca = manterMarca.pesquisarPorId(marcaId);
            boolean delete = manterMarca.excluir(marca);
            if (delete != false) {
                jsp = ListarMarca.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Marca!";
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
