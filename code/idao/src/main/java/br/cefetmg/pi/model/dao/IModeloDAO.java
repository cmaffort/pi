package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface IModeloDAO {

    Long inserir(Modelo modelo) throws PersistenciaException;

    boolean atualizar(Modelo modelo) throws PersistenciaException;

    boolean delete(Modelo modelo) throws PersistenciaException;

    ArrayList<Modelo> listarTodos() throws PersistenciaException;

    Modelo consultarPorId(Long id) throws PersistenciaException;
}
