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

public class GravarInsercaoCliente {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            String nome = request.getParameter("nome");

            Long codCidade = Long.parseLong(request.getParameter("codcidade"));
            IManterCidade manterCidade = new ManterCidade();
            Cidade cidade = manterCidade.pesquisarPorId(codCidade);

            String bairro = request.getParameter("bairro");
            String cpf = request.getParameter("cpf");

            String dataStr = request.getParameter("datanasc");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNasc = formatter.parse(dataStr);

            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            String fone = request.getParameter("fone");

            Cliente cliente = new Cliente();

            cliente.setNome(nome);
            cliente.setCidade(cidade);
            cliente.setBairro(bairro);
            cliente.setCpf(cpf);
            cliente.setDataNasc(dataNasc);
            cliente.setEmail(email);
            cliente.setEndereco(endereco);
            cliente.setFone(fone);

            IManterCliente manterCliente = new ManterCliente();
            Long clienteId = manterCliente.cadastrar(cliente);

            if (clienteId != null) {
                jsp = ListarCliente.execute(request);
            } else {
                String erro = "Nao foi possivel gravar esse registro!";
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
