package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.dto.VeiculoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.cefetmg.pi.dao.connection.ConnectionManager;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;

public class VeiculoClienteDAO implements IVeiculoClienteDAO {

    @Override
    public Long inserir(VeiculoCliente veiculoCliente) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO veiculocliente (cliente_id, veiculo_id) VALUES(?,?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, veiculoCliente.getCliente().getId());
            pstmt.setLong(2, veiculoCliente.getVeiculo().getId());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = rs.getLong("id");
                veiculoCliente.setId(id);
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
    public boolean atualizar(VeiculoCliente veiculoCliente) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE veiculocliente "
                       + "   SET cliente_id = ?, "
                       + "       veiculo_id = ? "
                       + " WHERE id = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, veiculoCliente.getCliente().getId());
            pstmt.setLong(2, veiculoCliente.getVeiculo().getId());
            pstmt.setLong(3, veiculoCliente.getId());
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
    public boolean delete(VeiculoCliente veiculoCliente) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM veiculocliente WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, veiculoCliente.getId());
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
    public ArrayList<VeiculoCliente> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM veiculocliente;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<VeiculoCliente> listAll = null;
            IClienteDAO clienteDAO = new ClienteDAO();
            IVeiculoDAO veiculoDAO = new VeiculoDAO();
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    VeiculoCliente veiculoCliente = new VeiculoCliente();
                    veiculoCliente.setId(rs.getLong("id"));
                    Cliente cliente = clienteDAO.consultarPorId(rs.getLong("cliente_id"));
                    veiculoCliente.setCliente(cliente);
                    Veiculo veiculo = veiculoDAO.consultarPorId(rs.getLong("veiculo_id"));
                    veiculoCliente.setVeiculo(veiculo);
                    listAll.add(veiculoCliente);
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
    public VeiculoCliente consultarPorId(Long id) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM veiculoCliente WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            VeiculoCliente veiculoCliente = null;
            IClienteDAO clienteDAO = new ClienteDAO();
            IVeiculoDAO veiculoDAO = new VeiculoDAO();
            if (rs.next()) {
                veiculoCliente = new VeiculoCliente();
                veiculoCliente.setId(rs.getLong("id"));
                    Cliente cliente = clienteDAO.consultarPorId(rs.getLong("cliente_id"));
                    veiculoCliente.setCliente(cliente);
                    Veiculo veiculo = veiculoDAO.consultarPorId(rs.getLong("veiculo_id"));
                    veiculoCliente.setVeiculo(veiculo);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return veiculoCliente;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
