package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.VeiculoCliente;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface IVeiculoClienteDAO {

    Long inserir(VeiculoCliente veiculoCliente) throws PersistenciaException;

    boolean atualizar(VeiculoCliente veiculoCliente) throws PersistenciaException;

    boolean delete(VeiculoCliente veiculoCliente) throws PersistenciaException;

    ArrayList<VeiculoCliente> listarTodos() throws PersistenciaException;

    VeiculoCliente consultarPorId(Long id) throws PersistenciaException;
}
