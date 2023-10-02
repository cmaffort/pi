package br.cefetmg.inf.sisloc.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.service.IManterModelo;
import br.cefetmg.pi.model.service.ManterModelo;

public class GravarInsercaoModelo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            String descricao = request.getParameter("descricao");

            Modelo modelo = new Modelo();
            modelo.setDescricao(descricao);

            IManterModelo manterModelo = new ManterModelo();
            Long modeloId = manterModelo.cadastrar(modelo);
            
            if (modeloId != null) {
                jsp = ListarModelo.execute(request);
            } else {
                String erro = "Nao foi possivel gravar esse registro!";
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
