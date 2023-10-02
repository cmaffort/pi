package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface IMarcaDAO {

    Long inserir(Marca marca) throws PersistenciaException;

    boolean atualizar(Marca marca) throws PersistenciaException;

    boolean delete(Marca marca) throws PersistenciaException;

    ArrayList<Marca> listarTodos() throws PersistenciaException;

    Marca consultarPorId(Long id) throws PersistenciaException;
}
