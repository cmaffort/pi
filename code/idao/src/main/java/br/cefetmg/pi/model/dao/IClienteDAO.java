package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface IClienteDAO {

    Long inserir(Cliente cliente) throws PersistenciaException;

    boolean atualizar(Cliente cliente) throws PersistenciaException;

    boolean delete(Cliente cliente) throws PersistenciaException;

    ArrayList<Cliente> listarTodos() throws PersistenciaException;

    Cliente consultarPorId(Long id) throws PersistenciaException;
}
