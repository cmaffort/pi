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
import jakarta.servlet.http.HttpServletRequest;

public class GravarAlteracaoVeiculo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long codVeiculo = Long.parseLong(request.getParameter("codveiculo"));
            String placa = request.getParameter("placa");
            Long codModelo = Long.parseLong(request.getParameter("codmodelo"));
            Long codMarca = Long.parseLong(request.getParameter("codmarca"));
            Long codCategoria = Long.parseLong(request.getParameter("codcategoria"));
            String descricao = request.getParameter("descricao");

            IManterModelo manterModelo = new ManterModelo();
            Modelo modelo = manterModelo.pesquisarPorId(codModelo);

            IManterMarca manterMarca = new ManterMarca();
            Marca marca = manterMarca.pesquisarPorId(codMarca);

            IManterCategoria manterCategoria = new ManterCategoria();
            Categoria categoria = manterCategoria.pesquisarPorId(codCategoria);

            Veiculo veiculo = new Veiculo();
            veiculo.setId(codVeiculo);
            veiculo.setPlaca(placa);
            veiculo.setModelo(modelo);
            veiculo.setMarca(marca);
            veiculo.setCategoria(categoria);
            veiculo.setDescricao(descricao);

            IManterVeiculo manterVeiculo = new ManterVeiculo();
            boolean updated = manterVeiculo.alterar(veiculo);
            
            if (updated == true) {
                jsp = ListarVeiculo.execute(request);
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
