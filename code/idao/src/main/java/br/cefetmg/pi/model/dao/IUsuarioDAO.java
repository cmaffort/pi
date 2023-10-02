package br.cefetmg.pi.model.dao;

import br.cefetmg.pi.model.dto.Usuario;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.ArrayList;

public interface IUsuarioDAO {

    Long inserir(Usuario usuario) throws PersistenciaException;

    boolean atualizar(Usuario usuario) throws PersistenciaException;

    boolean delete(Usuario usuario) throws PersistenciaException;

    ArrayList<Usuario> listarTodos() throws PersistenciaException;

    Usuario consultarPorId(Long id) throws PersistenciaException;
    
    Usuario consultarPorUsuarioSenha(String nome, String senha) throws PersistenciaException;
}
