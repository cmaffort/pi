package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface IVeiculoDAO {

    Long inserir(Veiculo veiculo) throws PersistenciaException;

    boolean atualizar(Veiculo veiculo) throws PersistenciaException;

    boolean delete(Veiculo veiculo) throws PersistenciaException;

    ArrayList<Veiculo> listarTodos() throws PersistenciaException;

    Veiculo consultarPorId(Long id) throws PersistenciaException;
    
    Veiculo consultarPorPlaca(String placa) throws PersistenciaException;
}
