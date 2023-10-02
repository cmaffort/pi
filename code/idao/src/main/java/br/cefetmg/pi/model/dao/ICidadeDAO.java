package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface ICidadeDAO {

    Long inserir(Cidade cidade) throws PersistenciaException;

    boolean atualizar(Cidade cidade) throws PersistenciaException;

    boolean delete(Cidade cidade) throws PersistenciaException;

    ArrayList<Cidade> listarTodos() throws PersistenciaException;

    Cidade consultarPorId(Long id) throws PersistenciaException;

}
