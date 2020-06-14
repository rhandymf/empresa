package br.com.empresa.bo;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.empresa.entity.Usuario;
import br.com.empresa.entity.dto.UsuarioDTO;

@Service
public class UsuarioBO {

	@Autowired
	private ModelMapper modelMapper;
	
	public List<UsuarioDTO> converterListaUsuarioParaDTO(List<Usuario> listaUsuarios) {
		List<UsuarioDTO> listaUsuariosDTO = null;

		if (!CollectionUtils.isEmpty(listaUsuarios)) {
			Type listType = new TypeToken<List<UsuarioDTO>>() {}.getType();
			listaUsuariosDTO = modelMapper.map(listaUsuarios, listType);
		}

		return listaUsuariosDTO;
	}

	public UsuarioDTO converterUsuarioParaDTO(Usuario usuario) {
		return usuario != null ? modelMapper.map(usuario, UsuarioDTO.class) : null;
	}

	public Usuario converterDTOParaUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = null;
		
		if(usuarioDTO != null && usuarioDTO.getNome() != null) {
			usuario = modelMapper.map(usuarioDTO, Usuario.class);
		}
		
		return usuario;
	}

}
