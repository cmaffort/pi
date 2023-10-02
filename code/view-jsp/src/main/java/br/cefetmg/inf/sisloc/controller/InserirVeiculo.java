package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.service.IManterCategoria;
import br.cefetmg.pi.model.service.IManterMarca;
import br.cefetmg.pi.model.service.IManterModelo;
import br.cefetmg.pi.model.service.ManterCategoria;
import br.cefetmg.pi.model.service.ManterMarca;
import br.cefetmg.pi.model.service.ManterModelo;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class InserirVeiculo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            //lista de marcas
            IManterMarca manterMarca = new ManterMarca();
            List<Marca> listMarca = manterMarca.pesquisarTodos();

            //lista de modelos
            IManterModelo manterModelo = new ManterModelo();
            List<Modelo> listModelo = manterModelo.pesquisarTodos();

            //lista de categorias
            IManterCategoria manterCategoria = new ManterCategoria();
            List<Categoria> listCategoria = manterCategoria.pesquisarTodos();

            if (listMarca == null || listModelo == null || listCategoria == null) {
                String erro = "Nao existe registro!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            } else {
                request.setAttribute("listMarca", listMarca);
                request.setAttribute("listModelo", listModelo);
                request.setAttribute("listCategoria", listCategoria);
                jsp = "/inserirveiculo.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
