package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.service.IManterCliente;
import br.cefetmg.pi.model.service.IManterVeiculo;
import br.cefetmg.pi.model.service.ManterCliente;
import br.cefetmg.pi.model.service.ManterVeiculo;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class InserirVeiculoCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            //lista de marcas
            IManterCliente manterCliente = new ManterCliente();
            List<Cliente> listCliente = manterCliente.pesquisarTodos();
            //lista de modelos
            IManterVeiculo manterVeiculo = new ManterVeiculo();
            List<Veiculo> listVeiculo = manterVeiculo.pesquisarTodos();

            if (listCliente == null || listVeiculo == null) {
                String erro = "Nao existe registro!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            } else {
                request.setAttribute("listCliente", listCliente);
                request.setAttribute("listVeiculo", listVeiculo);
                jsp = "/inserirveiculocliente.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
