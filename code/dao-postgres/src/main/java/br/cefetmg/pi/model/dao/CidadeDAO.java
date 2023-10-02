package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.dto.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.cefetmg.pi.dao.connection.ConnectionManager;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;

public class CidadeDAO implements ICidadeDAO {

    @Override
    public Long inserir(Cidade cidade) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO cidade (nome, estado_id) VALUES(?, ?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cidade.getNome());
            pstmt.setLong(2, cidade.getEstado().getId());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                cidade.setId(id);
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
    public boolean atualizar(Cidade cidade) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();
            
            String sql = "UPDATE cidade " +
                           " SET nome = ?, " +
                           "     estado_id = ? " +                           
                         " WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cidade.getNome());
            pstmt.setLong(2, cidade.getEstado().getId());
            pstmt.setLong(3, cidade.getId());
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
    public boolean delete(Cidade cidade) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM cidade WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cidade.getId());
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
    public ArrayList<Cidade> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM cidade ORDER BY nome";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Cidade> listAll = null;
            IEstadoDAO estadoDAO = new EstadoDAO();
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Cidade cidade = new Cidade();
                    cidade.setId(rs.getLong("id"));
                    cidade.setNome(rs.getString("nome"));
                    Estado estado = estadoDAO.consultarPorId(rs.getLong("estado_id"));
                    cidade.setEstado(estado);
                    listAll.add(cidade);
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
    public Cidade consultarPorId(Long id) throws PersistenciaException {
        
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM cidade WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Cidade cidade = null;
            IEstadoDAO estadoDAO = new EstadoDAO();
            if (rs.next()) {
                cidade = new Cidade();
                cidade.setId(rs.getLong("id"));
                cidade.setNome(rs.getString("nome"));
                Estado estado = estadoDAO.consultarPorId(rs.getLong("estado_id"));
                cidade.setEstado(estado);
            }

            rs.close();
            pstmt.close();
            connection.close();
            
            return cidade;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
