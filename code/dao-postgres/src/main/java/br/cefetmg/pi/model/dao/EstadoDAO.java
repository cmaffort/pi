package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.cefetmg.pi.dao.connection.ConnectionManager;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;

public class EstadoDAO implements IEstadoDAO {

    @Override
    public Long inserir(Estado estado) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO estado (sigla, nome) VALUES(?,?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, estado.getSigla());
            pstmt.setString(2, estado.getNome());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = rs.getLong("id");
                estado.setId(id);
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
    public boolean atualizar(Estado estado) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();
            
            String sql = "UPDATE estado " +
                           " SET sigla = ?, " +
                           "     nome = ? " +
                         " WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, estado.getSigla());
            pstmt.setString(2, estado.getNome());
            pstmt.setLong(2, estado.getId());
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
    public boolean delete(Estado estado) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM estado WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, estado.getId());
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
    public ArrayList<Estado> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM estado ORDER BY sigla";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Estado> listAll = null;
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Estado estado = new Estado();
                    estado.setId(rs.getLong("id"));
                    estado.setSigla(rs.getString("sigla"));
                    estado.setNome(rs.getString("nome"));
                    listAll.add(estado);
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
    public Estado consultarPorId(Long id) throws PersistenciaException {
        
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM estado WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Estado estado = null;
            if (rs.next()) {
                estado = new Estado();
                estado.setId(rs.getLong("id"));
                estado.setSigla(rs.getString("sigla"));
                estado.setNome(rs.getString("nome"));
            }

            rs.close();
            pstmt.close();
            connection.close();
            
            return estado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Estado consultarPorSigla(String sigla) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM estado WHERE sigla = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, sigla);
            ResultSet rs = pstmt.executeQuery();

            Estado estado = null;
            if (rs.next()) {
                estado = new Estado();
                estado.setId(rs.getLong("id"));
                estado.setSigla(rs.getString("sigla"));
                estado.setNome(rs.getString("nome"));
            }

            rs.close();
            pstmt.close();
            connection.close();
            
            return estado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
