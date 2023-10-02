package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.service.IManterCategoria;
import br.cefetmg.pi.model.service.IManterMarca;
import br.cefetmg.pi.model.service.IManterModelo;
import br.cefetmg.pi.model.service.IManterVeiculo;
import br.cefetmg.pi.model.service.ManterCategoria;
import br.cefetmg.pi.model.service.ManterMarca;
import br.cefetmg.pi.model.service.ManterModelo;
import br.cefetmg.pi.model.service.ManterVeiculo;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarVeiculo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodVeiculo que se deseja alterar
            String placa = request.getParameter("Placa");
            IManterVeiculo manterVeiculo = new ManterVeiculo();
            Veiculo veiculo = manterVeiculo.pesquisarPorPlaca(placa);
            if (veiculo != null) {
                request.setAttribute("veiculo", veiculo);
                
                IManterMarca manterMarca = new ManterMarca();
                List<Marca> listMarca = manterMarca.pesquisarTodos();    
                request.setAttribute("listMarca", listMarca);
            
                IManterModelo manterModelo = new ManterModelo();
                List<Modelo> listModelo = manterModelo.pesquisarTodos();    
                request.setAttribute("listModelo", listModelo);

                IManterCategoria manterCategoria = new ManterCategoria();
                List<Categoria> listCategoria = manterCategoria.pesquisarTodos();    
                request.setAttribute("listCategoria", listCategoria);                
                
                jsp = "/alterarveiculo.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Veiculo!";
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
