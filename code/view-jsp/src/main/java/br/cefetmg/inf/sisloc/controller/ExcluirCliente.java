package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.service.IManterCliente;
import br.cefetmg.pi.model.service.ManterCliente;
import jakarta.servlet.http.HttpServletRequest;

public class ExcluirCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo repectiva cliente a ser excluida
            Long clienteId = Long.parseLong(request.getParameter("cod"));
            IManterCliente manterCliente = new ManterCliente();
            Cliente cliente = manterCliente.pesquisarPorId(clienteId);
            boolean delete = manterCliente.excluir(cliente);
            if (delete != false) {
                jsp = ListarCliente.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Cliente!";
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
