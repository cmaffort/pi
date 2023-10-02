package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.cefetmg.pi.dao.connection.ConnectionManager;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Long inserir(Cliente cliente) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO cliente (nome, cpf, datanasc, endereco, bairro, cidade_id, fone, email) VALUES(?,?,?,?,?,?,?,?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setDate(3, new java.sql.Date(cliente.getDataNasc().getTime()));
            
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setString(5, cliente.getBairro());
            pstmt.setLong(6, cliente.getCidade().getId());
            pstmt.setString(7, cliente.getFone());
            pstmt.setString(8, cliente.getEmail());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                cliente.setId(id);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean atualizar(Cliente cliente) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE cliente "
                    + "   SET nome = ?, "
                    + "       cpf = ?, "
                    + "       datanasc = ?, "
                    + "       endereco = ?, "
                    + "       bairro = ?, "
                    + "       cidade_id = ?, "
                    + "       fone = ?, "
                    + "       email = ? "
                    + " WHERE id = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setDate(3, new java.sql.Date(cliente.getDataNasc().getTime()));
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setString(5, cliente.getBairro());
            pstmt.setLong(6, cliente.getCidade().getId());
            pstmt.setString(7, cliente.getFone());
            pstmt.setString(8, cliente.getEmail());
            pstmt.setLong(9, cliente.getId());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(Cliente cliente) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM cliente WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cliente.getId());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Cliente> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM cliente ORDER BY nome";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Cliente> listAll = null;
            ICidadeDAO cidadeDAO = new CidadeDAO();
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setDataNasc(rs.getDate("datanasc"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setBairro(rs.getString("bairro"));
                    Cidade cidade = cidadeDAO.consultarPorId(rs.getLong("cidade_id"));
                    cliente.setCidade(cidade);
                    cliente.setFone(rs.getString("fone"));
                    cliente.setEmail(rs.getString("email"));
                    listAll.add(cliente);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Cliente consultarPorId(Long id) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM cliente WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Cliente cliente = null;
            ICidadeDAO cidadeDAO = new CidadeDAO();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNasc(rs.getDate("datanasc"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                Cidade cidade = cidadeDAO.consultarPorId(rs.getLong("cidade_id"));
                cliente.setCidade(cidade);
                cliente.setFone(rs.getString("fone"));
                cliente.setEmail(rs.getString("email"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
