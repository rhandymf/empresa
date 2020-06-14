package br.com.empresa.service;

import java.util.List;

import br.com.empresa.entity.dto.UsuarioDTO;

public interface UsuarioService {
	
	public List<UsuarioDTO> listarTodos();

	public UsuarioDTO inserir(UsuarioDTO usuario);

	public String excluir(Long id);

}
