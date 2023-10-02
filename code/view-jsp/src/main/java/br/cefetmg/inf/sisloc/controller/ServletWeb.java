package br.cefetmg.inf.sisloc.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletWeb extends HttpServlet {
    private String jsp = "";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        
        if(acao.equals("Logar"))
            jsp = Login.execute(request);
        else if (acao.equals("ListarEstados"))
            jsp = ListarEstado.execute(request);
        else if (acao.equals("AlterarEstado"))
            jsp = AlterarEstado.execute(request);
        else if (acao.equals("GravarAlteracaoEstado"))
            jsp = GravarAlteracaoEstado.execute(request);
        else if (acao.equals("GravarInsercaoEstado"))
            jsp = GravarInsercaoEstado.execute(request);
        else if (acao.equals("ExcluirEstado"))
            jsp = ExcluirEstado.execute(request);
        else if (acao.equals("ListarCidade"))
            jsp = ListarCidade.execute(request);
        else if (acao.equals("InserirCidade"))
            jsp = InserirCidade.execute(request);
        else if (acao.equals("AlterarCidade"))
            jsp = AlterarCidade.execute(request);
        else if (acao.equals("GravarAlteracaoCidade"))
            jsp = GravarAlteracaoCidade.execute(request);
        else if (acao.equals("GravarInsercaoCidade"))
            jsp = GravarInsercaoCidade.execute(request);
        else if (acao.equals("ExcluirCidade"))
            jsp = ExcluirCidade.execute(request);
        else if (acao.equals("ListarCliente"))
            jsp = ListarCliente.execute(request);
        else if (acao.equals("InserirCliente"))
            jsp = InserirCliente.execute(request);
        else if (acao.equals("AlterarCliente"))
            jsp = AlterarCliente.execute(request);
        else if (acao.equals("GravarAlteracaoCliente"))
            jsp = GravarAlteracaoCliente.execute(request);
        else if (acao.equals("GravarInsercaoCliente"))
            jsp = GravarInsercaoCliente.execute(request);
        else if (acao.equals("ExcluirCliente"))
            jsp = ExcluirCliente.execute(request);
        else if (acao.equals("ListarVeiculo"))
            jsp = ListarVeiculo.execute(request);
        else if (acao.equals("InserirVeiculo"))
            jsp = InserirVeiculo.execute(request);
        else if (acao.equals("AlterarVeiculo"))
            jsp = AlterarVeiculo.execute(request);
        else if (acao.equals("GravarAlteracaoVeiculo"))
            jsp = GravarAlteracaoVeiculo.execute(request);
        else if (acao.equals("GravarInsercaoVeiculo"))
            jsp = GravarInsercaoVeiculo.execute(request);
        else if (acao.equals("ExcluirVeiculo"))
            jsp = ExcluirVeiculo.execute(request);
        else if (acao.equals("ListarModelo"))
            jsp = ListarModelo.execute(request);
        else if (acao.equals("AlterarModelo"))
            jsp = AlterarModelo.execute(request);
        else if (acao.equals("GravarAlteracaoModelo"))
            jsp = GravarAlteracaoModelo.execute(request);
        else if (acao.equals("GravarInsercaoModelo"))
            jsp = GravarInsercaoModelo.execute(request);
        else if (acao.equals("ExcluirModelo"))
            jsp = ExcluirModelo.execute(request);
        else if (acao.equals("ListarMarca"))
            jsp = ListarMarca.execute(request);
        else if (acao.equals("AlterarMarca"))
            jsp = AlterarMarca.execute(request);
        else if (acao.equals("GravarAlteracaoMarca"))
            jsp = GravarAlteracaoMarca.execute(request);
        else if (acao.equals("GravarInsercaoMarca"))
            jsp = GravarInsercaoMarca.execute(request);
        else if (acao.equals("ExcluirMarca"))
            jsp = ExcluirMarca.execute(request);
        else if (acao.equals("ListarCategoria"))
            jsp = ListarCategoria.execute(request);
        else if (acao.equals("AlterarCategoria"))
            jsp = AlterarCategoria.execute(request);
        else if (acao.equals("GravarAlteracaoCategoria"))
            jsp = GravarAlteracaoCategoria.execute(request);
        else if (acao.equals("GravarInsercaoCategoria"))
            jsp = GravarInsercaoCategoria.execute(request);
        else if (acao.equals("ExcluirCategoria"))
            jsp = ExcluirCategoria.execute(request);
        else if (acao.equals("ListarUsuario"))
            jsp = ListarUsuario.execute(request);
        else if (acao.equals("AlterarUsuario"))
            jsp = AlterarUsuario.execute(request);
        else if (acao.equals("GravarAlteracaoUsuario"))
            jsp = GravarAlteracaoUsuario.execute(request);
        else if (acao.equals("GravarInsercaoUsuario"))
            jsp = GravarInsercaoUsuario.execute(request);
        else if (acao.equals("ExcluirUsuario"))
            jsp = ExcluirUsuario.execute(request);
        else if (acao.equals("ListarVeiculoCliente"))
            jsp = ListarVeiculoCliente.execute(request);
        else if (acao.equals("InserirVeiculoCliente"))
            jsp = InserirVeiculoCliente.execute(request);
        else if (acao.equals("AlterarVeiculoCliente"))
            jsp = AlterarVeiculoCliente.execute(request);
        else if (acao.equals("GravarAlteracaoVeiculoCliente"))
            jsp = GravarAlteracaoVeiculoCliente.execute(request);
        else if (acao.equals("GravarInsercaoVeiculoCliente"))
            jsp = GravarInsercaoVeiculoCliente.execute(request);
        else if (acao.equals("ExcluirVeiculoCliente"))
            jsp = ExcluirVeiculoCliente.execute(request);

        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }    
}
