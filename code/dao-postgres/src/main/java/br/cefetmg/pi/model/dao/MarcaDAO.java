package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.cefetmg.pi.dao.connection.ConnectionManager;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;

public class MarcaDAO implements IMarcaDAO {

    @Override
    public Long inserir(Marca marca) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO marca (descricao) VALUES(?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, marca.getDescricao());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                marca.setId(id);
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
    public boolean atualizar(Marca marca) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();
            
            String sql = "UPDATE marca " +
                         "   SET descricao = ? " +
                         " WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, marca.getDescricao());
            pstmt.setLong(2, marca.getId());
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
    public boolean delete(Marca marca) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM marca WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, marca.getId());
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
    public ArrayList<Marca> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM marca ORDER BY descricao";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Marca> listAll = null;
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Marca marca = new Marca();
                    marca.setId(rs.getLong("id"));
                    marca.setDescricao(rs.getString("descricao"));
                    listAll.add(marca);
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
    public Marca consultarPorId(Long id) throws PersistenciaException {
        
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM marca WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Marca marca = null;
            if (rs.next()) {
                marca = new Marca();
                marca.setId(rs.getLong("id"));
                marca.setDescricao(rs.getString("descricao"));
            }

            rs.close();
            pstmt.close();
            connection.close();
            
            return marca;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
