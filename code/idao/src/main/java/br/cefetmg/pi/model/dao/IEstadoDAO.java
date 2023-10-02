package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface IEstadoDAO {

    Long inserir(Estado estado) throws PersistenciaException;
    boolean atualizar(Estado estado) throws PersistenciaException;
    boolean delete(Estado estado) throws PersistenciaException;
    ArrayList<Estado> listarTodos() throws PersistenciaException;
    Estado consultarPorId(Long id) throws PersistenciaException;
    Estado consultarPorSigla(String sigla) throws PersistenciaException;
}
