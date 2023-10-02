package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.dto.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.cefetmg.pi.dao.connection.ConnectionManager;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;

public class VeiculoDAO implements IVeiculoDAO {

    @Override
    public Long inserir(Veiculo veiculo) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO veiculo (placa, modelo_id, marca_id, categoria_id, descricao) VALUES(?,?,?,?,?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setLong(2, veiculo.getModelo().getId());
            pstmt.setLong(3, veiculo.getMarca().getId());
            pstmt.setLong(4, veiculo.getCategoria().getId());
            pstmt.setString(5, veiculo.getDescricao());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                veiculo.setId(id);
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
    public boolean atualizar(Veiculo veiculo) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE veiculo "
                    + "   SET placa = ?, "
                    + "       modelo_id = ?, "
                    + "       marca_id = ?, "
                    + "       categoria_id = ?, "
                    + "       descricao = ? "
                    + " WHERE id = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setLong(2, veiculo.getModelo().getId());
            pstmt.setLong(3, veiculo.getMarca().getId());
            pstmt.setLong(4, veiculo.getCategoria().getId());
            pstmt.setString(5, veiculo.getDescricao());
            pstmt.setLong(6, veiculo.getId());
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
    public boolean delete(Veiculo veiculo) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM veiculo WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, veiculo.getId());
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
    public ArrayList<Veiculo> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM veiculo ORDER BY placa;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Veiculo> listAll = null;
            IModeloDAO modeloDAO = new ModeloDAO();
            IMarcaDAO marcaDAO = new MarcaDAO();
            ICategoriaDAO categoriaDAO = new CategoriaDAO();
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Veiculo veiculo = new Veiculo();
                    veiculo.setId(rs.getLong("id"));
                    veiculo.setPlaca(rs.getString("placa"));
                    Modelo modelo = modeloDAO.consultarPorId(rs.getLong("modelo_id"));
                    veiculo.setModelo(modelo);
                    Marca marca = marcaDAO.consultarPorId(rs.getLong("marca_id"));
                    veiculo.setMarca(marca);
                    Categoria categoria = categoriaDAO.consultarPorId(rs.getLong("categoria_id"));
                    veiculo.setCategoria(categoria);                    
                    veiculo.setDescricao(rs.getString("descricao"));
                    listAll.add(veiculo);
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
    public Veiculo consultarPorId(Long id) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM veiculo WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Veiculo veiculo = null;
            IModeloDAO modeloDAO = new ModeloDAO();
            IMarcaDAO marcaDAO = new MarcaDAO();
            ICategoriaDAO categoriaDAO = new CategoriaDAO();
            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setId(rs.getLong("id"));
                veiculo.setPlaca(rs.getString("placa"));
                Modelo modelo = modeloDAO.consultarPorId(rs.getLong("modelo_id"));
                veiculo.setModelo(modelo);
                Marca marca = marcaDAO.consultarPorId(rs.getLong("marca_id"));
                veiculo.setMarca(marca);
                Categoria categoria = categoriaDAO.consultarPorId(rs.getLong("categoria_id"));
                veiculo.setCategoria(categoria);                    
                veiculo.setDescricao(rs.getString("descricao"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return veiculo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Veiculo consultarPorPlaca(String placa) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM veiculo WHERE placa = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();

            Veiculo veiculo = null;
            IModeloDAO modeloDAO = new ModeloDAO();
            IMarcaDAO marcaDAO = new MarcaDAO();
            ICategoriaDAO categoriaDAO = new CategoriaDAO();
            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setId(rs.getLong("id"));
                veiculo.setPlaca(rs.getString("placa"));
                Modelo modelo = modeloDAO.consultarPorId(rs.getLong("modelo_id"));
                veiculo.setModelo(modelo);
                Marca marca = marcaDAO.consultarPorId(rs.getLong("marca_id"));
                veiculo.setMarca(marca);
                Categoria categoria = categoriaDAO.consultarPorId(rs.getLong("categoria_id"));
                veiculo.setCategoria(categoria);                    
                veiculo.setDescricao(rs.getString("descricao"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return veiculo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
