package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.service.IManterMarca;
import br.cefetmg.pi.model.service.ManterMarca;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarMarca {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Marca que deseja alterar
            String codMarca = request.getParameter("CodMarca");
            IManterMarca manterMarca = new ManterMarca();
            Marca marca = manterMarca.pesquisarPorId(Long.parseLong(codMarca));
            if(marca != null){
                request.setAttribute("marca",marca);
                jsp = "/alterarmarca.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Marca!";
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
