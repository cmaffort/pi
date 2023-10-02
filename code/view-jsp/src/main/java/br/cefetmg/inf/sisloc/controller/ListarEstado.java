package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.service.ManterEstado;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class ListarEstado {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterEstado manterEstados = new ManterEstado();
            List<Estado> listEstado = manterEstados.pesquisarTodos();
            if (listEstado != null) {
                request.setAttribute("listEstado", listEstado);
                jsp = "/listarestado.jsp";
            } else {
                String erro = "Nao existem estados cadastrados!";
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
