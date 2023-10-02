package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.service.IManterModelo;
import br.cefetmg.pi.model.service.ManterModelo;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarModelo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Modelo que deseja alterar
            Long codModelo = Long.parseLong(request.getParameter("CodModelo"));
            IManterModelo manterModelo = new ManterModelo();
            Modelo modelo = manterModelo.pesquisarPorId(codModelo);
            if (modelo != null) {
                request.setAttribute("modelo", modelo);
                jsp = "/alterarmodelo.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Modelo!";
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
