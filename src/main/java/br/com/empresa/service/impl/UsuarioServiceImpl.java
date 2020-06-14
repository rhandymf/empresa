package br.com.empresa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.bo.UsuarioBO;
import br.com.empresa.entity.Usuario;
import br.com.empresa.entity.dto.UsuarioDTO;
import br.com.empresa.repository.UsuarioRepository;
import br.com.empresa.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Resource
	private UsuarioBO bo;

	@Override
	public List<UsuarioDTO> listarTodos() {
		Iterable<Usuario> listaUsuarios = repository.findAll();

		return listaUsuarios != null 
				? bo.converterListaUsuarioParaDTO((List<Usuario>) listaUsuarios) : null;
	}

	@Override
	public UsuarioDTO inserir(UsuarioDTO usuarioDTO) {
		Usuario usuario = bo.converterDTOParaUsuario(usuarioDTO);
		
		return usuarioDTO != null 
					&& usuarioDTO.getNome() != null 
					&& !usuarioDTO.getNome().trim().isEmpty()
					&& usuarioDTO.getEmail() != null 
					&& !usuarioDTO.getEmail().trim().isEmpty()
					&& repository.findUsuarioByEmail(usuarioDTO.getEmail()) == null
					&& usuarioDTO.getSenha() != null 
					&& !usuarioDTO.getSenha().trim().isEmpty()
					&& usuarioDTO != null 
				? bo.converterUsuarioParaDTO(repository.save(usuario)) : null;
	}

	@Override
	public String excluir(Long id) {
		String msg = "Usuario não excluído.";
		
		if(repository.findById(id) != null) {
			repository.deleteById(id);
			
			msg = "Usuario excluído com sucesso.";
		}
		
		return msg;
	}

}
