package br.cefetmg.inf.sisloc.controller;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.service.IManterCidade;
import br.cefetmg.pi.model.service.IManterCliente;
import br.cefetmg.pi.model.service.ManterCidade;
import br.cefetmg.pi.model.service.ManterCliente;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;

public class GravarAlteracaoCliente {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long codCliente = Long.parseLong(request.getParameter("codcliente"));

            String nome = request.getParameter("nome");

            Long codCidade = Long.parseLong(request.getParameter("codcidade"));
            IManterCidade manterCidade = new ManterCidade();
            Cidade cidade = manterCidade.pesquisarPorId(codCidade);
            
            String bairro = request.getParameter("bairro");
            String cpf = request.getParameter("cpf");
            
            
            String dataStr = request.getParameter("dataNasc");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNasc = formatter.parse(dataStr);
            
            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            String fone = request.getParameter("fone");
            
            Cliente cliente = new Cliente();
            cliente.setId(codCliente);
            cliente.setNome(nome);
            cliente.setCidade(cidade);
            cliente.setBairro(bairro);
            cliente.setCpf(cpf);
            cliente.setDataNasc(dataNasc);
            cliente.setEmail(email);
            cliente.setEndereco(endereco);
            cliente.setFone(fone);
            
            IManterCliente manterCliente = new ManterCliente();
            boolean updated = manterCliente.alterar(cliente);
            
            if(updated == true)
                jsp = ListarCliente.execute(request);
            else{
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