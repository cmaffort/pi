package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.service.IManterCidade;
import br.cefetmg.pi.model.service.IManterCliente;
import br.cefetmg.pi.model.service.ManterCidade;
import br.cefetmg.pi.model.service.ManterCliente;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class AlterarCliente {
 
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodCliente que se deseja alterar
            String codCliente = request.getParameter("CodCliente");

            IManterCliente manterCliente = new ManterCliente();
            Cliente cliente = manterCliente.pesquisarPorId(Long.parseLong(codCliente));
            if(cliente !=null){
                request.setAttribute("cliente", cliente);
                
                IManterCidade manterCidade = new ManterCidade();
                List<Cidade> listCidade = manterCidade.pesquisarTodos();
                request.setAttribute("listCidade", listCidade);
                
                jsp = "/alterarcliente.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Cliente!";
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