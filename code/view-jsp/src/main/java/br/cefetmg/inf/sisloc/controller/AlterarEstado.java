package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.service.ManterEstado;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarEstado {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Estado que deseja alterar
            String Sigla = request.getParameter("Sigla");
            IManterEstado manterEstado = new ManterEstado();
            Estado estado = manterEstado.pesquisarPorSigla(Sigla);
            if(estado!=null){    
                request.setAttribute("estado",estado);
                jsp = "/alterarestado.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Estado!";
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
