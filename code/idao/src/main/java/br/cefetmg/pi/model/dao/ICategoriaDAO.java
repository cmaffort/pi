package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface ICategoriaDAO {

    Long inserir(Categoria categoria) throws PersistenciaException;

    boolean atualizar(Categoria categoria) throws PersistenciaException;

    boolean delete(Categoria categoria) throws PersistenciaException;

    ArrayList<Categoria> listarTodos() throws PersistenciaException;

    Categoria consultarPorId(Long id) throws PersistenciaException;
}
